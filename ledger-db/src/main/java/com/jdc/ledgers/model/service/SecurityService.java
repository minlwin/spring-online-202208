package com.jdc.ledgers.model.service;

import com.jdc.ledgers.model.form.SignInForm;
import com.jdc.ledgers.model.form.SignUpForm;

public interface SecurityService {

	public void signIn(SignInForm form);

	public void signUp(SignUpForm form);

}