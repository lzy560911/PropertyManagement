package com.lzy.pojo;

import java.io.Serializable;

public class Worker implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int w_id;
	private String w_name;
	private String w_sex;
	private String w_cardnumber;
	private String w_phone;
	private String d_name;
	
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_sex() {
		return w_sex;
	}
	public void setW_sex(String w_sex) {
		this.w_sex = w_sex;
	}
	public String getW_cardnumber() {
		return w_cardnumber;
	}
	public void setW_cardnumber(String w_cardnumber) {
		this.w_cardnumber = w_cardnumber;
	}
	public String getW_phone() {
		return w_phone;
	}
	public void setW_phone(String w_phone) {
		this.w_phone = w_phone;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	@Override
	public String toString() {
		return "Worker [w_id=" + w_id + ", w_name=" + w_name + ", w_sex=" + w_sex + ", w_cardnumber=" + w_cardnumber
				+ ", w_phone=" + w_phone + ", d_name=" + d_name + "]";
	}
	
}
