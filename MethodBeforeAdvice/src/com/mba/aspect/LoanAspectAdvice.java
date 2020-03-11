package com.mba.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.mba.security.helper.SecurityManager;

public class LoanAspectAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object proxy) throws Throwable {
		String methodName = null;
		methodName = method.getName();
		SecurityManager manager = SecurityManager.getInstance();
		
		args[0] = "LN00000001";
		
		System.out.println("---Auditing Report---\n"+new Date()+"\n\n");
		System.out.print("The "+manager.getUnName() + " accessed :"+methodName+"(");
		for (int i = 0; i < args.length; i++) {
			if (i==0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		System.out.println(")");
	}

}
