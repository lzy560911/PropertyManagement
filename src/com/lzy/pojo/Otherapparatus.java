package com.lzy.pojo;

import java.io.Serializable;

public class Otherapparatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ap_id;
	private String ap_name;
	private String ap_state;
	private String ap_time;
	private String ap_manufacturer;
	
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public String getAp_name() {
		return ap_name;
	}
	public void setAp_name(String ap_name) {
		this.ap_name = ap_name;
	}
	
	public String getAp_state() {
		return ap_state;
	}
	public void setAp_state(String ap_state) {
		this.ap_state = ap_state;
	}
	public String getAp_time() {
		return ap_time;
	}
	public void setAp_time(String ap_time) {
		this.ap_time = ap_time;
	}
	public String getAp_manufacturer() {
		return ap_manufacturer;
	}
	public void setAp_manufacturer(String ap_manufacturer) {
		this.ap_manufacturer = ap_manufacturer;
	}
	@Override
	public String toString() {
		return "Otherapparatus [ap_id=" + ap_id + ", ap_name=" + ap_name + ", ap_state=" + ap_state + ", ap_time="
				+ ap_time + ", ap_manufacturer=" + ap_manufacturer + "]";
	}
	
}
