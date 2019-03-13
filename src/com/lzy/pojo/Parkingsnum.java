package com.lzy.pojo;

import java.io.Serializable;

public class Parkingsnum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String parkings_num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParkings_num() {
		return parkings_num;
	}
	public void setParkings_num(String parkings_num) {
		this.parkings_num = parkings_num;
	}
	
	

}
