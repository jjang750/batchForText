package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.STARTED) {
			log.info("!!! START INSPECTION_MASTER BATCH JOB !!!");
			log.info(" DELETE FROM INSPECTION_MASTER : " + jdbcTemplate.update(" DELETE FROM HJIN.INSPECTION_MASTER "));
		}
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results" );
			log.info(" INSPECTION_MASTER COUNT : " + jdbcTemplate.queryForMap("SELECT COUNT(*) AS CNT FROM HJIN.INSPECTION_MASTER" ) .get("CNT").toString());
//
//			jdbcTemplate.query("SELECT first_name, last_name FROM people",
//				(rs, row) -> new PersonVo(
//					rs.getString(1),
//					rs.getString(2))
//			).forEach(person -> log.info("Found <" + person + "> in the database."));
		}
	}
}
