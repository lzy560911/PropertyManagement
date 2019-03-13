package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IPay;
import com.lzy.pojo.Pay;
import com.opensymphony.xwork2.ActionSupport;

public class PayAction extends ActionSupport  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pay pay;
	private IPay payDao;
	private int id;
	private String h_house_number;
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public IPay getPayDao() {
		return payDao;
	}
	public void setPayDao(IPay payDao) {
		this.payDao = payDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getH_house_number() {
		return h_house_number;
	}
	public void setH_house_number(String h_house_number) {
		this.h_house_number = h_house_number;
	}
	//�����Ϣ
	public String PayAdd() throws Exception {
		// TODO Auto-generated method stub
		payDao.add(pay);
		System.out.println("��ӽɷ�ƾ֤�ɹ�");
		return this.OwnerUpdate();
	}
	
	//����
	public String OwnerUpdate() throws Exception {
		// TODO Auto-generated method stub
		payDao.update(pay);
		System.out.println("���½ɷ�״̬�ɹ�!!!!");
		return "jfsuccess";
	}
	
	public String Printvoucher() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ƾ֤��ӡ");
		System.out.println(h_house_number);
		ServletActionContext.getRequest().getSession()
		.setAttribute("printvoucher", payDao.printvoucher(h_house_number));
		System.out.println("׼������ƾ֤��ӡ");
		System.out.println();
		return "printvoucher";
	}

}
