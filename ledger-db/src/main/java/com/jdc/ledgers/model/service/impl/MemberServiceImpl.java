package com.jdc.ledgers.model.service.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.ledgers.model.LedgersDbException;
import com.jdc.ledgers.model.form.PasswordForm;
import com.jdc.ledgers.model.result.UserProfile;
import com.jdc.ledgers.model.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public MemberServiceImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	public void changePass(PasswordForm form) {
		
		// Get Login User Information
		String username = getLoginUserName();
		
		// Get Old Password from Database
		String passwordFromDb = getOldPassword(username);
		
		// Check Old Password
		if(!passwordEncoder.matches(form.getOldPass(), passwordFromDb)) {
			// throw business exception
			throw new LedgersDbException("Please check your old password.");
		}
		
		// Update New Password
		template.update("update member set password = :password where email = :username", 
				Map.of(
					"password", passwordEncoder.encode(form.getNewPass()),
					"username", username
				));
	}

	public UserProfile getUserProfile() {
		return template.queryForObject("""
			select id, name, email, role, create_date createDate from 
			member where email = :username""", 
				Map.of("username", getLoginUserName()), 
				new BeanPropertyRowMapper<>(UserProfile.class));
	}

	private String getLoginUserName() {
		var security = SecurityContextHolder.getContext();
		return security.getAuthentication().getName();
	}

	private String getOldPassword(String username) {
		return template.queryForObject("select password from member where email = :username", 
				Map.of("username", username), String.class);
	}

}