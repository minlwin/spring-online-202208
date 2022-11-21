package com.jdc.ledgers.model.service;

import com.jdc.ledgers.model.form.PasswordForm;
import com.jdc.ledgers.model.result.UserProfile;

public interface MemberService {

	public void changePass(PasswordForm form);

	public UserProfile getUserProfile();

}