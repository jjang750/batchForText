package com.example.batchprocessing;

import com.example.batchprocessing.beans.InspectionMasterVo;
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
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@Repository
public class InspectionMasterBatchConfiguration  extends JdbcDaoSupport {

    private static final Logger log = LoggerFactory.getLogger(InspectionMasterBatchConfiguration.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    // end::setup[]
    @Bean
    public FlatFileItemReader<InspectionMasterVo> reader() {
        FlatFileItemReader<InspectionMasterVo> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("EH060505.20220513"));
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper((line, lineNumber) -> {
            if (line.startsWith("31") || line.startsWith("33") ) {
                return null;
            }

            InspectionMasterVo inspectionMasterVo = new InspectionMasterVo(line, lineNumber);
            return inspectionMasterVo;
        });




        return flatFileItemReader;
    }
    @Bean
    public InspectionMasterItemProcessor processor() {
        return new InspectionMasterItemProcessor();
    }

    @Autowired
    public void setSuperDatasource(DataSource ds){
        super.setDataSource(ds);
    }

    @Bean
    public JdbcBatchItemWriter<InspectionMasterVo> writer(DataSource dataSource) {

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


        return new JdbcBatchItemWriterBuilder<InspectionMasterVo>()
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
    public Step step1(JdbcBatchItemWriter<InspectionMasterVo> writer) {
        return stepBuilderFactory.get("step1")
                .<InspectionMasterVo, InspectionMasterVo> chunk(1000)
                .reader(reader())
                .faultTolerant()
                .noRollback(NullPointerException.class)
                .noRollback(FlatFileParseException.class)
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
