package com.jdc.ledgers.model.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.ledgers.model.form.EntryDataForm;
import com.jdc.ledgers.model.result.EntryData;
import com.jdc.ledgers.model.service.EntryDataService;

@Service
public class EntryDataServiceImpl implements EntryDataService {
	
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insert;

	public EntryDataServiceImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
	}

	public EntryData findById(int id) {
		// TODO implement here
		return null;
	}

	public EntryData save(EntryDataForm form) {
		// TODO implement here
		return null;
	}

	public List<EntryData> search(int ledgerId, LocalDate from, LocalDate to) {
		// TODO implement here
		return null;
	}

}