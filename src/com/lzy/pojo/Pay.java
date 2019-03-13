package com.lzy.pojo;

import java.io.Serializable;

//½ÉÄÉË®µç·Ñ
public class Pay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int p_id;
	private String p_name;
	private String h_house_number;
	private String p_phone;
	private String p_should;
	private String p_real;
	private String p_time;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	public String getP_phone() {
		return p_phone;
	}
	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}
	public String getP_should() {
		return p_should;
	}
	public void setP_should(String p_should) {
		this.p_should = p_should;
	}
	public String getP_real() {
		return p_real;
	}
	public void setP_real(String p_real) {
		this.p_real = p_real;
	}
	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	@Override
	public String toString() {
		return "Pay [p_id=" + p_id + ", p_name=" + p_name + ", h_house_number=" + h_house_number + ", p_phone="
				+ p_phone + ", p_should=" + p_should + ", p_real=" + p_real + ", p_time=" + p_time + "]";
	}

}
