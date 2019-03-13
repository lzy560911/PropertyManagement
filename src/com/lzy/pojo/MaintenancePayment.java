package com.lzy.pojo;

import java.io.Serializable;

public class MaintenancePayment implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int m_id;
	private String h_house_number;
	private String m_name;
	private String m_phone;
	private String m_work;
	private String m_money;
	private String m_time;
	
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_work() {
		return m_work;
	}
	public void setM_work(String m_work) {
		this.m_work = m_work;
	}
	public String getM_money() {
		return m_money;
	}
	public void setM_money(String m_money) {
		this.m_money = m_money;
	}
	public String getM_time() {
		return m_time;
	}
	public void setM_time(String m_time) {
		this.m_time = m_time;
	}
	@Override
	public String toString() {
		return "MaintenancePayment [m_id=" + m_id + ", h_house_number=" + h_house_number + ", m_name=" + m_name
				+ ", m_phone=" + m_phone + ", m_work=" + m_work + ", m_money=" + m_money + ", m_time=" + m_time + "]";
	}
}
