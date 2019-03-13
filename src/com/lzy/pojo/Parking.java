package com.lzy.pojo;

import java.io.Serializable;

public class Parking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int p_id;
	private String p_name;
	private String h_house_number;
	private String p_time;
	private String oc_licenseplate;
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
	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	public String getOc_licenseplate() {
		return oc_licenseplate;
	}
	public void setOc_licenseplate(String oc_licenseplate) {
		this.oc_licenseplate = oc_licenseplate;
	}
	@Override
	public String toString() {
		return "Parking [p_id=" + p_id + ", p_name=" + p_name + ", h_house_number=" + h_house_number + ", p_time="
				+ p_time + ", oc_licenseplate=" + oc_licenseplate + "]";
	}
	
	

}
