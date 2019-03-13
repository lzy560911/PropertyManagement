package com.lzy.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.ILoginUser;
import com.lzy.pojo.Administrators;

public class LoginUser extends HibernateDaoSupport implements ILoginUser {

	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrators> checkname() {
		// TODO Auto-generated method stub
		List<Administrators> users =this.getCurSession().createSQLQuery("select a.A_name,a.A_password from a_user a").list();
		return users;
	}

	public int findUserName(String Username) {
		// TODO Auto-generated method stub
		System.out.println("ready to find");
		int t=this.getCurSession().createQuery("from Administrators a where A_name ='"+Username+"'").list().size();
		System.out.println(t);
		return t;
	}
	
	public int findPhone(String Phone) {
		// TODO Auto-generated method stub
		System.out.println("ready to find");
		int phoneNum=this.getCurSession().createQuery("from Administrators a where A_phone ='"+Phone+"'").list().size();
		System.out.println(phoneNum);
		return phoneNum;
	}
}
