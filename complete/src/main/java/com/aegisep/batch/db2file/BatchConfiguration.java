package com.aegisep.batch.db2file;

import com.aegisep.batch.dto.ResidentVo;
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

		sql.append("select b.aptcd, a.orgaptcd, a.dongho, a.occu_date, a.rel, a.name, a.mobile_tel_no1 \n" +
				"from resident a, apt b \n" +
				"where a.orgaptcd = b.orgaptcd");

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
			setFormat("%-5s%-5s%-8s%-8s%-10s%-10s%-13s");
			setFieldExtractor(new BeanWrapperFieldExtractor<>() {{
				setNames(new String[]{"aptcd", "orgaptcd", "dongho", "occu_date", "rel", "name", "mobile_tel_no1"});
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
