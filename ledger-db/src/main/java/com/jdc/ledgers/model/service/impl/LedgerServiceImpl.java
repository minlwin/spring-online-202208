package com.jdc.ledgers.model.service.impl;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jdc.ledgers.model.form.LedgerForm;
import com.jdc.ledgers.model.result.Ledger;
import com.jdc.ledgers.model.result.MonthlyReport;
import com.jdc.ledgers.model.result.YearlyReport;
import com.jdc.ledgers.model.service.LedgerService;

@Service
public class LedgerServiceImpl implements LedgerService {

	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	private static final String SELECT_SQL = """
			select l.id, l.name, l.type, l.description, l.deleted, m.id ownerId, m.name ownerName 
			from ledger l join member m on l.owner_id = m.id""";
	
	public LedgerServiceImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("ledger");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of(
				"name", "type", "owner_id", "description", "deleted"
		));
	}

	public List<Ledger> getUserLedgers() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return template.query(SELECT_SQL.concat(" m.email = :username"), 
				Map.of("username", username), 
				new BeanPropertyRowMapper<>(Ledger.class));
	}

	public void save(LedgerForm form) {
		if(form.getId() == 0) {
			insert(form);
		} else {
			update(form);
		}
	}

	public Ledger findById(int id) {
		return template.queryForObject(SELECT_SQL.concat(" l.id = :id"), 
				Map.of("id", id), new BeanPropertyRowMapper<>(Ledger.class));
	}

	public List<YearlyReport> getYearlyReport(int year) {
		// TODO implement here
		return null;
	}

	public List<MonthlyReport> getMonthlyReport(YearMonth month) {
		// TODO implement here
		return null;
	}

	private void update(LedgerForm form) {
		template.update("""
			update ledger set name = :name, type = :type, description = :description, deleted = :deleted 
			where id = :id""", 
				new BeanPropertySqlParameterSource(form));
	}

	private void insert(LedgerForm form) {
		insert.execute(Map.of(
				"name", form.getName(),
				"type", form.getType(),
				"description", form.getDescription(),
				"deleted", form.isDeleted()
				));
	}

}