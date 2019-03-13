package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IMoney;
import com.lzy.pojo.Owner;

public class MoneyDao extends HibernateDaoSupport implements IMoney{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询水电费信息中");
		Query query=this.getCurSession().createQuery("from Owner where o_state = '0'");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Owner>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Owner where o_state = '0'").list().size();
		System.out.println(t);
		return t;
	}
	@SuppressWarnings("unchecked")
	public List<Owner> findAlready(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询水电费信息中");
		Query query=this.getCurSession().createQuery("from Owner where o_state = '1'");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Owner>)query.list();
	}
	public int getReadySize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Owner where o_state = '1'").list().size();
		System.out.println(t);
		return t;
	}
	

	public void update(Owner owner) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Owner o set o.o_name='"+owner.getO_name()+"',o.o_cardnumber='"+owner.getO_cardnumber()+"',o.h_house_number='"+owner.getH_house_number()+"',o.o_phone='"+owner.getO_phone()+"',o.o_time='"+owner.getO_time()+"' where o.o_id='"+owner.getO_id()+"'").executeUpdate();
	}
	public Owner findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID缴费信息");
		return (Owner)this.getCurSession().createQuery("from Owner where id=?").setParameter(0, id).uniqueResult();
	}
	public Owner findByHomeNumber(String homenumber) {
		// TODO Auto-generated method stub
		System.out.println("按照名字查询业主信息");
		return (Owner)this.getCurSession().createQuery("from Owner where h_house_number=?").setParameter(0, homenumber).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Owner> findByCondition_two(String search_num, String search_name) {
		// TODO Auto-generated method stub
		Query query=this.getCurSession().createQuery("from Owner where h_house_number like '"+"%"+search_num+"%"+"' and o_name like '"+"%"+search_name+"%"+"'");
		return (List<Owner>)query.list();
	}
}
