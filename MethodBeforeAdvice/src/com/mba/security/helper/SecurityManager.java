package com.mba.security.helper;

import com.mba.securtiy.beans.User;

public class SecurityManager {
	private static SecurityManager instance;
	ThreadLocal<User> threadLocal = new ThreadLocal<>();

	private SecurityManager() {
		threadLocal = new ThreadLocal<>();
	}

	public static synchronized SecurityManager getInstance() {
		if (instance == null) {
			instance = new SecurityManager();
		}
		return instance;
	}

	public void login(String un, String pwd) {
		User user = new User(un, pwd);
		threadLocal.set(user);
	}

	public boolean authenticate() {
		if (threadLocal.get() != null) {
			if (threadLocal.get().getUn().equals("mike") && threadLocal.get().getPwd().equals("welcome1")) {
				System.out.println("Login successful.");
				return true;
			}
		}
		return false;

	}

	public void logout() {
		threadLocal.set(null);
	}
	public String getUnName() {
		String newUn = threadLocal.get().getUn();
		return newUn;
	} 
}
