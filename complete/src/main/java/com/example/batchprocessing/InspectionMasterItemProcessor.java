package com.example.batchprocessing;

import com.example.batchprocessing.beans.InspectionMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InspectionMasterItemProcessor implements ItemProcessor<InspectionMaster, InspectionMaster> {

	private static final Logger log = LoggerFactory.getLogger(InspectionMasterItemProcessor.class);

	@Override
	public InspectionMaster process(final InspectionMaster inspectionMaster) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		inspectionMaster.setTRANS_DATE(format.format(Calendar.getInstance().getTime()));
		inspectionMaster.setCREATEDT(format.format(Calendar.getInstance().getTime()));

		log.info("process (" + inspectionMaster + ") ");
//
//		final InspectionMaster transformedPerson = new InspectionMaster();
//
//		log.info("Converting (" + inspectionMaster + ") into (" + transformedPerson + ")");

		return inspectionMaster;
	}





}
