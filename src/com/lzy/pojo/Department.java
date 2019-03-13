package com.lzy.pojo;

import java.io.Serializable;

public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int d_id;
	private String d_name;
	private String d_leader;
	private String d_phone;
	

	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_leader() {
		return d_leader;
	}
	public void setD_leader(String d_leader) {
		this.d_leader = d_leader;
	}
	public String getD_phone() {
		return d_phone;
	}
	public void setD_phone(String d_phone) {
		this.d_phone = d_phone;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", d_name=" + d_name + ", d_leader=" + d_leader + ", d_phone=" + d_phone
				+ "]";
	}
}
