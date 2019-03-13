package com.lzy.pojo;

import java.io.Serializable;

public class Repair implements Serializable{

	/**
	 * 保修表实体类
	 */
	private static final long serialVersionUID = 1L;
	private int r_id;
	private String h_house_number;
	private String r_name;
	private String r_phone;
	private String r_message;
	private String r_time;
	private boolean r_state;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_phone() {
		return r_phone;
	}
	public void setR_phone(String r_phone) {
		this.r_phone = r_phone;
	}
	public String getR_message() {
		return r_message;
	}
	public void setR_message(String r_message) {
		this.r_message = r_message;
	}
	public String getR_time() {
		return r_time;
	}
	public void setR_time(String r_time) {
		this.r_time = r_time;
	}
	public boolean isR_state() {
		return r_state;
	}
	public void setR_state(boolean r_state) {
		this.r_state = r_state;
	}
	@Override
	public String toString() {
		return "Repair [r_id=" + r_id + ", h_house_number=" + h_house_number + ", r_name=" + r_name + ", r_phone="
				+ r_phone + ", r_message=" + r_message + ", r_time=" + r_time + ", r_state=" + r_state + "]";
	}
}
