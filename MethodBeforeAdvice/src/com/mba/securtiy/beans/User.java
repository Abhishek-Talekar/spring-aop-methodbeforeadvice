package com.mba.securtiy.beans;

public class User {
	protected String un;
	protected String pwd;

	public User(String un, String pwd) {
		super();
		this.un = un;
		this.pwd = pwd;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [un=" + un + ", pwd=" + pwd + "]";
	}

}
