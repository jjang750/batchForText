package com.example.batchprocessing;

import com.example.batchprocessing.beans.PersonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<PersonVo, PersonVo> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public PersonVo process(final PersonVo personVo) throws Exception {
		final String firstName = personVo.getFirstName().replaceAll("\\s", "").toUpperCase();
		final String lastName = personVo.getLastName().replaceAll("\\s", "").toUpperCase();

		final PersonVo transformedPersonVo = new PersonVo(firstName, lastName);

		log.info("Converting (" + personVo + ") into (" + transformedPersonVo + ")");

		return transformedPersonVo;
	}

}
