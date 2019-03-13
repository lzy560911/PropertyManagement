package com.lzy.pojo;

import java.io.Serializable;

public class Cars implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int oc_id;
	private String oc_name;
	private String oc_color;
	private String oc_licenseplate;
	public int getOc_id() {
		return oc_id;
	}
	public void setOc_id(int oc_id) {
		this.oc_id = oc_id;
	}
	public String getOc_name() {
		return oc_name;
	}
	public void setOc_name(String oc_name) {
		this.oc_name = oc_name;
	}
	public String getOc_color() {
		return oc_color;
	}
	public void setOc_color(String oc_color) {
		this.oc_color = oc_color;
	}
	public String getOc_licenseplate() {
		return oc_licenseplate;
	}
	public void setOc_licenseplate(String oc_licenseplate) {
		this.oc_licenseplate = oc_licenseplate;
	}
	@Override
	public String toString() {
		return "Cars [oc_id=" + oc_id + ", oc_name=" + oc_name + ", oc_color=" + oc_color + ", oc_licenseplate="
				+ oc_licenseplate + "]";
	}
	
	

}
