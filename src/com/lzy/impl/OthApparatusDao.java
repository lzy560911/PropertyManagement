package com.lzy.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IOthApparatus;
import com.lzy.pojo.Otherapparatus;


public class OthApparatusDao extends HibernateDaoSupport implements IOthApparatus{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	
	public void add(Otherapparatus otherapparatus) {
		// TODO Auto-generated method stub
		this.getCurSession().save(otherapparatus);

	}
	
	@SuppressWarnings("unchecked")
	public List<Otherapparatus> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询其他信息中");
		Query query=this.getCurSession().createQuery("from Otherapparatus");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Otherapparatus>)query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Otherapparatus> findAll() {
		// TODO Auto-generated method stub
		System.out.println("查询其他信息中");
		Query query=this.getCurSession().createQuery("from Otherapparatus");
		return (List<Otherapparatus>)query.list();
	}
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Otherapparatus a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Otherapparatus otherapparatus=new Otherapparatus();
		otherapparatus.setAp_id(id);
		this.getCurSession().delete(otherapparatus);
	}
	
	public Otherapparatus findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询摄像头信息");
		return (Otherapparatus)this.getCurSession().createQuery("from Otherapparatus where id=?").setParameter(0, id).uniqueResult();
	}
	public void update(Otherapparatus otherapparatus) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Otherapparatus ap set ap.ap_manufacturer='"+otherapparatus.getAp_manufacturer()+"',ap.ap_name='"+otherapparatus.getAp_name()+"',ap.ap_state='"+otherapparatus.getAp_state()+"',ap.ap_time='"+otherapparatus.getAp_time()+"' where ap.ap_id='"+otherapparatus.getAp_id()+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Otherapparatus> findByCondition_two(String app_aname,String app_name,String app_time){
		// TODO Auto-generated method stub
		System.out.println("多条件查询摄像头信息中");
		Query query=this.getCurSession().createQuery("from Otherapparatus where ap_name like '"+"%"+app_aname+"%"+"' and ap_manufacturer like '"+"%"+app_name+"%"+"' and ap_time like '"+"%"+app_time+"%"+"'");
		return (List<Otherapparatus>)query.list();
	}
}
