package com.example.batchprocessing;

import com.example.batchprocessing.beans.InspectionMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Repository
public class InspectionMasterItemProcessor extends JdbcDaoSupport implements ItemProcessor<InspectionMaster, InspectionMaster> {

	private static final Logger log = LoggerFactory.getLogger(InspectionMasterItemProcessor.class);

	@Override
	public InspectionMaster process(final InspectionMaster inspectionMaster) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		getJdbcTemplate().update(" DELETE FROM HJIN.INSPECTION_MASTER WHERE CUST_NO = '"+ inspectionMaster.getCUST_NO() +"' AND CREATEDT = '" +format.format(Calendar.getInstance().getTime())+ "' ");
//		Map actcd = getJdbcTemplate().queryForMap("SELECT APTCD FROM HJIN.service_apt WHERE CUST_NO = '"+ inspectionMaster.getCUST_NO() +"' ");
//		if(!actcd.isEmpty()) inspectionMaster.setAPTCD(actcd.get("APTCD").toString());

		inspectionMaster.setTRANS_DATE(format.format(Calendar.getInstance().getTime()));
		inspectionMaster.setCREATEDT(format.format(Calendar.getInstance().getTime()));

		log.info("process (" + inspectionMaster + ") ");



//
//		final InspectionMaster transformedPerson = new InspectionMaster();
//
//		log.info("Converting (" + inspectionMaster + ") into (" + transformedPerson + ")");

		return inspectionMaster;
	}

	@Autowired
	public void setSuperDatasource(DataSource ds){
		super.setDataSource(ds);
	}
}
