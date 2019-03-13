package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IApparatus;
import com.lzy.pojo.Apparatus;




public class ApparatusDao extends HibernateDaoSupport implements IApparatus{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}

	public void add(Apparatus apparatus){
		this.getCurSession().save(apparatus);
	}
	
	@SuppressWarnings("unchecked")
	public List<Apparatus> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询健身器信息中");
		Query query=this.getCurSession().createQuery("from Apparatus");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Apparatus>)query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Apparatus> findAll() {
		// TODO Auto-generated method stub
		Query query=this.getCurSession().createQuery("from Apparatus");
		return (List<Apparatus>)query.list();
	}
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Apparatus a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Apparatus apparatus=new Apparatus();
		apparatus.setA_id(id);
		this.getCurSession().delete(apparatus);
	}
	
	public Apparatus findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询健身器信息");
		return (Apparatus)this.getCurSession().createQuery("from Apparatus where id=?").setParameter(0, id).uniqueResult();
	}
	public void update(Apparatus apparatus) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Apparatus a set a.a_manufacturer='"+apparatus.getA_manufacturer()+"',a.a_name='"+apparatus.getA_name()+"',a.a_state='"+apparatus.getA_state()+"',a.a_time='"+apparatus.getA_time()+"' where a.a_id='"+apparatus.getA_id()+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Apparatus> findByCondition_two(String app_aname,String app_name,String app_time){
		// TODO Auto-generated method stub
		System.out.println("多条件查询摄像头信息中");
		Query query=this.getCurSession().createQuery("from Apparatus where a_name like '"+"%"+app_aname+"%"+"' and a_manufacturer like '"+"%"+app_name+"%"+"' and a_time like '"+"%"+app_time+"%"+"'");
		return (List<Apparatus>)query.list();
	}
}
