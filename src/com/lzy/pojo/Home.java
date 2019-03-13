package com.lzy.pojo;

import java.io.Serializable;

public class Home implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int h_id;
	private String h_house_number;
	private String h_state;
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	public String getH_state() {
		return h_state;
	}
	public void setH_state(String h_state) {
		this.h_state = h_state;
	}
	@Override
	public String toString() {
		return "Home [h_id=" + h_id + ", h_house_number=" + h_house_number + ", h_state=" + h_state + "]";
	}
	
}
