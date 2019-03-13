package com.lzy.pojo;

import java.io.Serializable;

public class Owner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int o_id;
	private String o_name;
	private String o_cardnumber;
	private String h_house_number;
	private String o_phone;
	private String o_time;
	private String o_state;
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getO_cardnumber() {
		return o_cardnumber;
	}
	public void setO_cardnumber(String o_cardnumber) {
		this.o_cardnumber = o_cardnumber;
	}
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	public String getO_phone() {
		return o_phone;
	}
	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	
	public String getO_state() {
		return o_state;
	}
	public void setO_state(String o_state) {
		this.o_state = o_state;
	}
	@Override
	public String toString() {
		return "Owner [o_id=" + o_id + ", o_name=" + o_name + ", o_cardnumber=" + o_cardnumber + ", h_house_number="
				+ h_house_number + ", o_phone=" + o_phone + ", o_time=" + o_time + ", o_state=" + o_state + "]";
	}
	
}
