package com.mba.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mba.security.helper.SecurityManager;

public class SecurityCheckAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object proxy) throws IllegalAccessException {
		SecurityManager securityManager = SecurityManager.getInstance();
		boolean ststus = securityManager.authenticate();
		if (ststus==false) {
			throw new IllegalAccessException("Invalid username/pwd");
		}

	}
}
