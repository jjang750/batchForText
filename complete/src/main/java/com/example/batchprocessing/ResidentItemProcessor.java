package com.example.batchprocessing;

import com.example.batchprocessing.beans.ResidentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class ResidentItemProcessor implements ItemProcessor<ResidentVo, ResidentVo> {

	private static final Logger log = LoggerFactory.getLogger(ResidentItemProcessor.class);

	@Override
	public ResidentVo process(final ResidentVo residentVo) throws Exception {

		final ResidentVo transformedResidentVo = new ResidentVo();

		transformedResidentVo.setAptcd(residentVo.getAptcd());
		transformedResidentVo.setOrgaptcd(residentVo.getOrgaptcd());
		transformedResidentVo.setDongho(residentVo.getDongho());
		transformedResidentVo.setOccu_date(residentVo.getOccu_date());
		transformedResidentVo.setRel(residentVo.getRel());

		log.info("Converting (" + residentVo + ") into (" + transformedResidentVo + ")");

		return transformedResidentVo;
	}

}
