package com.jdc.ledgers.model.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
	
	private static final String SELECT = """
			select e.id, e.details, e.use_date useDate, e.quantity, e.price unitPrice, 
			ld.id ledgerId, ld.type ledgerType, ld.name ledgerName, m.id ownerId, m.name ownerName 
			from entry_data e join ledger ld on e.ledger_id = ld.id join member m on ld.owner_id = m.id""";

	public EntryDataServiceImpl(DataSource dataSource) {
		
		template = new NamedParameterJdbcTemplate(dataSource);
		
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("entry_data");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("ledger_id", "details", "use_date", "quantity", "price"));
	}

	public EntryData findById(int id) {
		return template.queryForObject(SELECT.concat(" where e.id = :id"), 
				Map.of("id", id), new BeanPropertyRowMapper<>(EntryData.class));
	}

	public EntryData save(EntryDataForm form) {
		int id = (form.getId() == 0) ? insert(form) : update(form);
		return findById(id);
	}

	public List<EntryData> search(Integer ledgerId, LocalDate from, LocalDate to) {
		var sb = new StringBuffer(SELECT).append(" where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != ledgerId) {
			sb.append(" and e.ledger_id = :ledgerId");
			params.put("ledgerId", ledgerId);
		}
		
		if(null != from) {
			sb.append(" and e.use_date >= :from");
			params.put("from", Date.valueOf(from));
		}
		
		if(null != to) {
			sb.append(" and e.use_date <= :to");
			params.put("to", Date.valueOf(to));
		}
		
		return template.query(sb.toString(), params, new BeanPropertyRowMapper<>(EntryData.class));
	}

	private int insert(EntryDataForm form) {
		return insert.executeAndReturnKey(new BeanPropertySqlParameterSource(form)).intValue();
	}

	private int update(EntryDataForm form) {
		if(template.update("""
				update entry_data set ledger_id = :ledgerId, details = :details, use_date = :useDate, 
				quantity = :quantity, price = :unitPrice where id = :id
				""", 
				new BeanPropertySqlParameterSource(form)) > 0) {
			return form.getId();
		}
		return 0;
	}

}