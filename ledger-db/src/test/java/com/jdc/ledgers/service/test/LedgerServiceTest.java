package com.jdc.ledgers.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ledgers.model.form.LedgerForm;
import com.jdc.ledgers.model.form.LedgerForm.LedgerType;
import com.jdc.ledgers.model.service.LedgerService;

@Sql({
	"/member/data.sql",
	"/ledger/data.sql"
})
@WithMockUser(username = "admin@gmail.com", authorities = {"Admin"})
@SpringJUnitConfig(locations = "classpath:/database-config.xml")
public class LedgerServiceTest {

	@Autowired
	private LedgerService service;
	
	@ParameterizedTest
	void test_save_create(int id, String name, LedgerType type, String description, boolean deleted) {
		
		LedgerForm form = new LedgerForm(name, type, description, deleted);
		var result = service.save(form);
		
		assertNotNull(result);
		assertEquals(id, result.getId());
	}
	
	@ParameterizedTest
	void test_save_update(int id, String name, LedgerType type, String description, boolean deleted) {
		LedgerForm form = new LedgerForm(name, type, description, deleted);
		var result = service.save(form);
		
		assertNotNull(result);
		assertEquals(id, result.getId());
	}
	
	@ParameterizedTest
	void test_find_by_id(int id, String name, LedgerType type, String description, boolean deleted) {
		var result = service.findById(id);
		
		assertNotNull(result);
		assertEquals(id, result.getId());
	}
}
