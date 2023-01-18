package com.aegisep.batch.db2file;

import com.aegisep.batch.beans.ResidentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FormatterLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@Repository
public class BatchConfiguration {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Value("${aegis.batch.chunkSize}")
	private int chunkSize;

	@Autowired
	private DataSource dataSource;

	@Bean
	public JdbcCursorItemReader<ResidentVo> jdbcCursorItemReader() {

		log.debug("jdbcCursorItemReader");

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT b.aptcd, a.orgaptcd, a.dongho, a.xdate AS occu_date, a.rel\n" +
				"FROM (\n" +
				"  SELECT ROWNUM AS xnum, orgaptcd, dongho, xdate, rel \n" +
				"  FROM (\n" +
				"    SELECT orgaptcd, dongho, CASE WHEN occu_date != '00000000' THEN occu_date \n" +
				"    WHEN reg_date != '00000000' THEN reg_date ELSE upd_date END AS xdate, rel\n" +
				"    FROM (\n" +
				"      SELECT orgaptcd, dongho, NVL(occu_date,'00000000') AS occu_date, NVL(reg_date,'00000000') AS reg_date, NVL(upd_date,'00000000') AS upd_date, CASE WHEN INSTR(rel,'세대') > 0 THEN 'Y' ELSE 'N' END AS rel\n" +
				"      FROM map.resident \n" +
				"      \n" +
				"        WHERE delflag IS NULL\n" +
				"    ) ORDER BY xdate DESC\n" +
				"  )\n" +
				") a, hjin.apt b\n" +
				"WHERE a.orgaptcd = b.orgaptcd \n");

		return new JdbcCursorItemReaderBuilder<ResidentVo>()
				.name("jdbcCursorItemReader")   //reader name
				.fetchSize(chunkSize)
				.dataSource(dataSource)
				.rowMapper(new BeanPropertyRowMapper<>(ResidentVo.class))
				.sql(sql.toString())
				.build();
	}

	@Bean
	public FlatFileItemWriter<ResidentVo> fixedLengthFileItemWriter(){

		log.debug("fixedLengthFileItemWriter ");

		FlatFileItemWriter<ResidentVo> writer = new FlatFileItemWriter<>();
		writer.setEncoding("UTF-8");
		writer.setResource(new FileSystemResource("output/RS001.20230118.txt"));
		writer.setLineAggregator(new FormatterLineAggregator<>() {{
			setFormat("%-5s%-5s%-8s%-8s%-1s");
			setFieldExtractor(new BeanWrapperFieldExtractor<>() {{
				setNames(new String[]{"aptcd", "orgaptcd", "dongho", "occu_date", "rel"});
			}});
		}});
		return writer;
	}

	@Bean
	public ResidentItemProcessor processor() {
		return new ResidentItemProcessor();
	}

	@Bean
	public Job importUserJob() {
		return jobBuilderFactory.get("importUserJob")
			.incrementer(new RunIdIncrementer())
			.flow(step1())
			.end()
			.build();
	}

	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1")
			.<ResidentVo, ResidentVo> chunk(chunkSize)
			.reader(jdbcCursorItemReader())
			.processor(processor())
			.writer(fixedLengthFileItemWriter())
			.build();
	}
}
