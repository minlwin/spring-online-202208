package com.jdc.ledgers.service.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ledgers.model.LedgersDbException;
import com.jdc.ledgers.model.form.PasswordForm;
import com.jdc.ledgers.model.result.UserProfile.Role;
import com.jdc.ledgers.model.service.MemberService;

@Sql("/member/data.sql")
@WithMockUser(username = "admin@gmail.com", authorities = {"Admin"})
@SpringJUnitConfig(locations = "classpath:/database-config.xml")
public class MemberServiceTest {

	@Autowired
	private MemberService service;
	
	@ParameterizedTest
	@CsvSource({
		"hello-spring,newpassword"
	})
	void test_change_password(String oldPass, String newPass) {
		PasswordForm form = new PasswordForm();
		form.setNewPass(newPass);
		form.setOldPass(oldPass);
		
		assertDoesNotThrow(() -> service.changePass(form));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Hello-spring,newpassword"
	})
	void test_change_password_error(String oldPass, String newPass) {
		PasswordForm form = new PasswordForm();
		form.setNewPass(newPass);
		form.setOldPass(oldPass);
		
		var exception = assertThrows(LedgersDbException.class, () -> service.changePass(form));
		assertEquals("Please check your old password.", exception.getMessage());
	}
	
	@Test
	void test_get_user_profile() {
		var profile = service.getUserProfile();
		
		assertNotNull(profile);
		assertEquals(1, profile.getId());
		assertEquals("Admin User", profile.getName());
		assertEquals("admin@gmail.com", profile.getEmail());
		assertEquals(Role.Admin, profile.getRole());
		assertEquals(LocalDate.of(2022, 11, 1), profile.getCreateDate());
	}	
	
	@Test
	@WithMockUser(username = "member@gmail.com")
	void test_get_user_profile_for_member() {
		var profile = service.getUserProfile();
		
		assertNotNull(profile);
		assertEquals(2, profile.getId());
		assertEquals("Member", profile.getName());
		assertEquals("member@gmail.com", profile.getEmail());
		assertEquals(Role.Member, profile.getRole());
		assertEquals(LocalDate.of(2022, 11, 15), profile.getCreateDate());
	}
}
