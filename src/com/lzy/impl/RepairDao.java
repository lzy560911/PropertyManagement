package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.IRepair;
import com.lzy.pojo.MaintenancePayment;
import com.lzy.pojo.Repair;

public class RepairDao extends HibernateDaoSupport implements IRepair{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Repair> findAll() {
		// TODO Auto-generated method stub
		System.out.println("查询保修信息中");
		return (List<Repair>)this.getCurSession().createQuery("from Repair").list();
	}
	
	public void add(Repair repair) {
		// TODO Auto-generated method stub
		this.getCurSession().save(repair);
	}
	
	public void updateByid(int id) {
		System.out.println("ready to update !");
		System.out.println("id is ："+id);
		this.getCurSession().createQuery("Update Repair r set r.r_state='"+"true"+"' where r.r_id='"+id+"'").executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Repair> repairShowFalse() {
		// TODO Auto-generated method stub
		System.out.println("show false !!");
		return (List<Repair>)this.getCurSession().createQuery("from Repair where r_state = 'false'").list();
	}
	public Repair findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询汽车信息");
		return (Repair)this.getCurSession().createQuery("from Repair where id=?").setParameter(0, id).uniqueResult();
	}
	
	public void add_voucher(MaintenancePayment maintenancePayment) {
		// TODO Auto-generated method stub
		this.getCurSession().save(maintenancePayment);
	}
	@SuppressWarnings("unchecked")
	public List<MaintenancePayment> findSuccessAll() {
		// TODO Auto-generated method stub
		System.out.println("查询保修信息中");
		return (List<MaintenancePayment>)this.getCurSession().createQuery("from MaintenancePayment").list();
	}
	public MaintenancePayment printvoucher(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID保修凭证信息");
		return (MaintenancePayment)this.getCurSession().createQuery("from MaintenancePayment where id=?").setParameter(0, id).uniqueResult();
	}
	
	//多条件查询保修表
	@SuppressWarnings("unchecked")
	public List<Repair> findByCondition_two(String search_name, String search_mess, String search_phone) {
		// TODO Auto-generated method stub
		Query query=this.getCurSession().createQuery("from Repair where r_name like '"+"%"+search_name+"%"+"' and r_message like '"+"%"+search_mess+"%"+"' and r_phone like '"+"%"+search_phone+"%"+"'");
		return (List<Repair>)query.list();	
	}
	//多条件查询维修凭证表
	@SuppressWarnings("unchecked")
	public List<MaintenancePayment> findByCondition_three(String search_oname, String search_ophone,String search_rname) {
		Query query=this.getCurSession().createQuery("from MaintenancePayment where m_name like '"+"%"+search_oname+"%"+"' and m_phone like '"+"%"+search_ophone+"%"+"' and m_work like '"+"%"+search_rname+"%"+"'");
		return (List<MaintenancePayment>)query.list();	
	}
}
