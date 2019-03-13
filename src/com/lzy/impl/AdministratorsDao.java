package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IAdministrators;
import com.lzy.pojo.Administrators;


public class AdministratorsDao extends HibernateDaoSupport implements IAdministrators{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Administrators> findAll() {
		// TODO Auto-generated method stub
		System.out.println("查询管理员信息中");
		return (List<Administrators>)this.getCurSession().createQuery("from Administrators").list();
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Administrators administrators=new Administrators();
		administrators.setA_id(id);;
		this.getCurSession().delete(administrators);
	}
	
	public void add(Administrators administrators) {
		// TODO Auto-generated method stub
		this.getCurSession().save(administrators);
	}

	public void update(Administrators administrators) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Administrators a set a.A_name='"+administrators.getA_name()+"',a.A_password='"+administrators.getA_password()+"',a.A_phone='"+administrators.getA_phone()+"' where a.A_id='"+administrators.getA_id()+"'").executeUpdate();
	}
	public Administrators findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询汽车信息");
		return (Administrators)this.getCurSession().createQuery("from Administrators where id=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Administrators> findByphone(String phone,String security) {
		// TODO Auto-generated method stub
		System.out.println("按照电话号码查询密码信息");
		return (List<Administrators>)this.getCurSession().createQuery("from Administrators where A_phone ='"+phone+"' and A_security ='"+security+"'").list();
		//return (Administrators)this.getCurSession().createQuery("from Administrators where A_phone=? and A_security=?").setParameter(0, phone).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Administrators> findme(String me) {
		// TODO Auto-generated method stub
		return (List<Administrators>)this.getCurSession().createQuery("from Administrators where A_name ='"+me+"'").list();
	}
	
	
	
}
