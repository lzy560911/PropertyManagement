package com.lzy.pojo;

import java.io.Serializable;

public class Apparatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a_id;
	private String a_name;
	private String a_state;
	private String a_time;
	private String a_manufacturer;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_state() {
		return a_state;
	}
	public void setA_state(String a_state) {
		this.a_state = a_state;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String a_time) {
		this.a_time = a_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getA_manufacturer() {
		return a_manufacturer;
	}
	public void setA_manufacturer(String a_manufacturer) {
		this.a_manufacturer = a_manufacturer;
	}
	@Override
	public String toString() {
		return "Apparatus [a_id=" + a_id + ", a_name=" + a_name + ", a_state=" + a_state + ", a_time=" + a_time
				+ ", a_manufacturer=" + a_manufacturer + "]";
	}
	
}
