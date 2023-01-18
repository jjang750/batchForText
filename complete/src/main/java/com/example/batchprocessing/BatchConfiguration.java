package com.example.batchprocessing;

import com.example.batchprocessing.beans.PersonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

// tag::setup[]
/*
@Configuration
@EnableBatchProcessing
*/
public class BatchConfiguration {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	// end::setup[]

	// tag::readerwriterprocessor[]
	@Bean
	public FlatFileItemReader<PersonVo> reader() {
//		return new FlatFileItemReaderBuilder<PersonVo>()
//			.name("personItemReader")
//			.resource(new ClassPathResource("sample-data.csv"))
//			.delimited()
//			.names("firstName", "lastName")
//			.fieldSetMapper(new BeanWrapperFieldSetMapper<PersonVo>() {{
//				setTargetType(PersonVo.class);
//			}})
//			.build();
		return new FlatFileItemReaderBuilder<PersonVo>()
				.name("personItemReader")
				.resource(new ClassPathResource("sample-data.txt"))
				.fixedLength()
				.columns(new Range(1, 21), new Range(21, 42))
				.names("firstName", "lastName")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<PersonVo>() {{
					setTargetType(PersonVo.class);
				}})
				.build();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<PersonVo> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<PersonVo>()
			.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
			.sql("INSERT INTO people (person_id, first_name, last_name) VALUES (people_seq.nextval, :firstName, :lastName)")
			.dataSource(dataSource)
			.build();
	}
	// end::readerwriterprocessor[]

	// tag::jobstep[]
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
			.incrementer(new RunIdIncrementer())
			.listener(listener)
			.flow(step1)
				.next(lastStep())
			.end()
			.build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<PersonVo> writer) {
		return stepBuilderFactory.get("step1")
			.<PersonVo, PersonVo> chunk(10)
			.reader(reader())
			.processor(processor())
			.writer(writer)
			.build();
	}

	@Bean
	public Step lastStep(){
		return stepBuilderFactory.get("lastStep")
				.tasklet((contribution, chunkContext) -> {
					log.info("Last Step!!");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	// end::jobstep[]
}
