package com.lzy.impl;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.IPay;
import com.lzy.pojo.Pay;


public class PayDao extends HibernateDaoSupport implements IPay {
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	
	public void add(Pay pay) {
		// TODO Auto-generated method stub
		this.getCurSession().save(pay);
	}
	
	public void update(Pay pay) {
		// TODO Auto-generated method stub
		System.out.println("准备修改缴费状态喽");
		this.getCurSession().createQuery("Update Owner o set o.o_state= 1 where o.h_house_number='"+pay.getH_house_number()+"'").executeUpdate();
	}
	public Pay printvoucher(String h_house_number) {
		// TODO Auto-generated method stub
		System.out.println("按照房屋门牌号查询缴费凭证信息");
		return (Pay)this.getCurSession().createQuery("from Pay where h_house_number=?").setParameter(0, h_house_number).uniqueResult();
	}
}
