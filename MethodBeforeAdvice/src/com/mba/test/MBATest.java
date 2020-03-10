package com.mba.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mba.aspect.LoanAspectAdvice;
import com.mba.beans.LoanManager;

public class MBATest {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new LoanManager());
		factory.addAdvice(new LoanAspectAdvice());
		
		LoanManager manager = (LoanManager)factory.getProxy();
		boolean status = manager.approveLoan("LN12345");
		System.out.println("Loan Status : ? :"+status);
	}
}
