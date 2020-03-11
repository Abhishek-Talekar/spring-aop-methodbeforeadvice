package com.mba.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mba.aspect.LoanAspectAdvice;
import com.mba.aspect.SecurityCheckAdvice;
import com.mba.beans.LoanManager;
import com.mba.security.helper.SecurityManager;

public class MBATest {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new LoanManager());
		factory.addAdvice(new LoanAspectAdvice());
		factory.addAdvice(new SecurityCheckAdvice());
		
		SecurityManager manager = SecurityManager.getInstance();
		manager.login("mike", "welcome1");
		
		LoanManager loanManager = (LoanManager) factory.getProxy();
		boolean status = loanManager.approveLoan("LN12345");
		
		System.out.println("Loan Status : ? :" + status);
	}
}
