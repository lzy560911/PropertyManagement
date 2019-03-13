package com.lzy.pojo;

import java.io.Serializable;

public class Camera implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int c_id;
	private String c_name;
	private String c_gbid;
	private String c_state;
	private String c_time;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_gbid() {
		return c_gbid;
	}
	public void setC_gbid(String c_gbid) {
		this.c_gbid = c_gbid;
	}
	
	public String getC_state() {
		return c_state;
	}
	public void setC_state(String c_state) {
		this.c_state = c_state;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	@Override
	public String toString() {
		return "Camera [c_id=" + c_id + ", c_name=" + c_name + ", c_gbid=" + c_gbid + ", c_state=" + c_state
				+ ", c_time=" + c_time + "]";
	}
	
}
