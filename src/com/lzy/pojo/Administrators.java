package com.lzy.pojo;

import java.io.Serializable;

//管理员表
//登陆该系统
public class Administrators implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int A_id;
	private String A_name;
	private String A_password;
	private String A_phone;
	private String A_security;
	public int getA_id() {
		return A_id;
	}
	public void setA_id(int a_id) {
		A_id = a_id;
	}
	public String getA_name() {
		return A_name;
	}
	public void setA_name(String a_name) {
		A_name = a_name;
	}
	public String getA_password() {
		return A_password;
	}
	public void setA_password(String a_password) {
		A_password = a_password;
	}
	
	public String getA_phone() {
		return A_phone;
	}
	public void setA_phone(String a_phone) {
		A_phone = a_phone;
	}
	public String getA_security() {
		return A_security;
	}
	public void setA_security(String a_security) {
		A_security = a_security;
	}
	@Override
	public String toString() {
		return "Administrators [A_id=" + A_id + ", A_name=" + A_name + ", A_password=" + A_password + ", A_phone="
				+ A_phone + ", A_security=" + A_security + "]";
	}
}
