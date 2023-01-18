package com.example.batchprocessing;

import com.example.batchprocessing.beans.InspectionMasterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Repository
public class InspectionMasterItemProcessor extends JdbcDaoSupport implements ItemProcessor<InspectionMasterVo, InspectionMasterVo> {

	private static final Logger log = LoggerFactory.getLogger(InspectionMasterItemProcessor.class);

	@Override
	public InspectionMasterVo process(final InspectionMasterVo inspectionMasterVo) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

//		getJdbcTemplate().update(" DELETE FROM HJIN.INSPECTION_MASTER WHERE CUST_NO = '"+ inspectionMasterVo.getCUST_NO() +"' AND CREATEDT = '" +format.format(Calendar.getInstance().getTime())+ "' ");
//		Map actcd = getJdbcTemplate().queryForMap("SELECT APTCD FROM HJIN.service_apt WHERE CUST_NO = '"+ inspectionMasterVo.getCUST_NO() +"' ");
//		if(!actcd.isEmpty()) inspectionMasterVo.setAPTCD(actcd.get("APTCD").toString());

		inspectionMasterVo.setTRANS_DATE(format.format(Calendar.getInstance().getTime()));
		inspectionMasterVo.setCREATEDT(format.format(Calendar.getInstance().getTime()));

		//log.info("process (" + inspectionMasterVo + ") ");



//
//		final InspectionMasterVo transformedPerson = new InspectionMasterVo();
//
//		log.info("Converting (" + inspectionMasterVo + ") into (" + transformedPerson + ")");

		return inspectionMasterVo;
	}

	@Autowired
	public void setSuperDatasource(DataSource ds){
		super.setDataSource(ds);
	}
}
