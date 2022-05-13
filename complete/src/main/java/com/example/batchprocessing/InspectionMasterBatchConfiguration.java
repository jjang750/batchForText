package com.example.batchprocessing;

import com.example.batchprocessing.beans.InspectionMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class InspectionMasterBatchConfiguration {

    private static final Logger log = LoggerFactory.getLogger(InspectionMasterBatchConfiguration.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    // end::setup[]
    @Bean
    public FlatFileItemReader<InspectionMaster> reader() {
//		return new FlatFileItemReaderBuilder<InspectionMaster>()
//			.name("InspectionMasterItemReader")
//			.resource(new ClassPathResource("sample-data.csv"))
//			.delimited()
//			.names("firstName", "lastName")
//			.fieldSetMapper(new BeanWrapperFieldSetMapper<InspectionMaster>() {{
//				setTargetType(InspectionMaster.class);
//			}})
//			.build();

        //Range [] rangeList = {new Range(1, 21), new Range(21, 42)};

//        Range[] rangeList = {
//            new Range(12,14),
//            new Range(18,28),
//            new Range(28,36),
//            new Range(36,42),
//            new Range(42,44),
//            new Range(44,46),
//            new Range(48,50),
//            new Range(50,52),
//            new Range(52,61),
//            new Range(61,72),
//            new Range(72,83),
//            new Range(83,90),
//            new Range(123,134),
//            new Range(134,145),
//            new Range(145,154),
//            new Range(154,165),
//            new Range(165,174),
//            new Range(174,179),
//            new Range(350,360),
//            new Range(376,386),
//            new Range(386,388),
//            new Range(388,398),
//            new Range(489,499),
//            new Range(499,509),
//            new Range(509,519),
//            new Range(519,529),
//            new Range(529,539),
//            new Range(569,579),
//            new Range(579,589),
//            new Range(589,599),
//            new Range(599,742)
//
//        };
//
//        String [] cols = {
//                "REGULATION_DAY",
//                "CUST_NO",
//                "HOUSE_NO",
//                "BILLYM",
//                "NUMBER_OF_LIFE",
//                "NUMBER_OF_HANDICAPPED",
//                "NUMBER_OF_MERIT",
//                "NUMBER_OF_FAMILY",
//                "REAL_USAGE",
//                "FIRST_FARE",
//                "USAGE_FARE",
//                "USAGE_0_FARE",
//                "ELECTRIC_FARE",
//                "VAT",
//                "ELECTRIC_FUND",
//                "SUB_TOTAL",
//                "TV_FARE",
//                "DAN_SU",
//                "SUMMER_DISCOUNT",
//                "LOWER_INCOME_DISCOUNT2",
//                "NUMBER_OF_E_VOUCHER",
//                "E_VOUCHER_DISCOUNT",
//                "SUMMER_DISCOUNT_7",
//                "SUMMER_DISCOUNT_8",
//                "BABY_RETRO",
//                "ULJIN_SUP_FARE",
//                "BORYUNG_SUP_FARE",
//                "FUEL_ADJ_FARE",
//                "SOSANG_SUP_FARE",
//                "BOKJI_ADD_DISC",
//                "ETC"
//        };

        FlatFileItemReader<InspectionMaster> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("EH060424.20220503"));
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper((InspectionMaster::new)); //Lambda ((line, lineNumber) -> new InspectionMaster(line, lineNumber))

        return flatFileItemReader;

//        return new FlatFileItemReaderBuilder<InspectionMaster>()
//                .name("InspectionMasterItemReader")
//                .resource(new ClassPathResource("EH060424.20220503"))
//
//                .fixedLength()
//
//                .columns(rangeList)
//                .names(cols)
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<InspectionMaster>() {{
//                    setTargetType(InspectionMaster.class);
//                }})
//                .build();
    }

    @Bean
    public InspectionMasterItemProcessor processor() {
        return new InspectionMasterItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<InspectionMaster> writer(DataSource dataSource) {

        String sql = "INSERT INTO" + "\n" +
                "HJIN.INSPECTION_MASTER (" + "\n" +
                "APTCD," + "\n" +
                "DONGHO," + "\n" +
                "CURMONIND01_TYPE," + "\n" +
                "TRANS_STATE," + "\n" +
                "REGULATION_DAY," + "\n" +
                "CUST_NO," + "\n" +
                "HOUSE_NO," + "\n" +
                "BILLYM," + "\n" +
                "TRANS_DATE," + "\n" +
                "CREATEDT," + "\n" +
                "NUMBER_OF_LIFE," + "\n" +
                "NUMBER_OF_HANDICAPPED," + "\n" +
                "NUMBER_OF_MERIT," + "\n" +
                "NUMBER_OF_FAMILY," + "\n" +
                "REAL_USAGE," + "\n" +
                "FIRST_FARE," + "\n" +
                "USAGE_FARE," + "\n" +
                "USAGE_0_FARE," + "\n" +
                "ELECTRIC_FARE," + "\n" +
                "VAT," + "\n" +
                "ELECTRIC_FUND," + "\n" +
                "SUB_TOTAL," + "\n" +
                "TV_FARE," + "\n" +
                "DAN_SU," + "\n" +
                "SUMMER_DISCOUNT," + "\n" +
                "LOWER_INCOME_DISCOUNT2," + "\n" +
                "NUMBER_OF_E_VOUCHER," + "\n" +
                "E_VOUCHER_DISCOUNT," + "\n" +
                "SUMMER_DISCOUNT_7," + "\n" +
                "SUMMER_DISCOUNT_8," + "\n" +
                "BABY_RETRO," + "\n" +
                "ULJIN_SUP_FARE," + "\n" +
                "BORYUNG_SUP_FARE," + "\n" +
                "FUEL_ADJ_FARE," + "\n" +
                "SOSANG_SUP_FARE," + "\n" +
                "BOKJI_ADD_DISC" + "\n" +
                ")" + "\n" +
                "VALUES (" + "\n" +
                ":APTCD ," + "\n" +
                ":DONGHO ," + "\n" +
                "'0' ," + "\n" +
                "'0' ," + "\n" +
                ":REGULATION_DAY," + "\n" +
                ":CUST_NO," + "\n" +
                ":HOUSE_NO," + "\n" +
                ":BILLYM," + "\n" +
                ":TRANS_DATE," + "\n" +
                ":CREATEDT," + "\n" +
                ":NUMBER_OF_LIFE," + "\n" +
                ":NUMBER_OF_HANDICAPPED," + "\n" +
                ":NUMBER_OF_MERIT," + "\n" +
                ":NUMBER_OF_FAMILY," + "\n" +
                ":REAL_USAGE," + "\n" +
                ":FIRST_FARE," + "\n" +
                ":USAGE_FARE," + "\n" +
                ":USAGE_0_FARE," + "\n" +
                ":ELECTRIC_FARE," + "\n" +
                ":VAT," + "\n" +
                ":ELECTRIC_FUND," + "\n" +
                ":SUB_TOTAL," + "\n" +
                ":TV_FARE," + "\n" +
                ":DAN_SU," + "\n" +
                ":SUMMER_DISCOUNT," + "\n" +
                ":LOWER_INCOME_DISCOUNT2," + "\n" +
                ":NUMBER_OF_E_VOUCHER," + "\n" +
                ":E_VOUCHER_DISCOUNT," + "\n" +
                ":SUMMER_DISCOUNT_7," + "\n" +
                ":SUMMER_DISCOUNT_8," + "\n" +
                ":BABY_RETRO," + "\n" +
                ":ULJIN_SUP_FARE," + "\n" +
                ":BORYUNG_SUP_FARE," + "\n" +
                ":FUEL_ADJ_FARE," + "\n" +
                ":SOSANG_SUP_FARE," + "\n" +
                ":BOKJI_ADD_DISC" + "\n" +
                ") ";

        return new JdbcBatchItemWriterBuilder<InspectionMaster>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(sql)
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
    public Step step1(JdbcBatchItemWriter<InspectionMaster> writer) {
        return stepBuilderFactory.get("step1")
                .<InspectionMaster, InspectionMaster> chunk(1000)
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
