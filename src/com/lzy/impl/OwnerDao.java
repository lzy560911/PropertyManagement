package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.IOwner;
import com.lzy.pojo.Owner;


public class OwnerDao extends HibernateDaoSupport implements IOwner{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Owner> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询车辆信息中");
		Query query=this.getCurSession().createQuery("from Owner");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Owner>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Owner a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("删除业主车辆信息");
		Owner owner=new Owner();
		owner.setO_id(id);;
		this.getCurSession().delete(owner);
	}
	public void add(Owner owner) {
		// TODO Auto-generated method stub
		this.getCurSession().save(owner);
	}
	public Owner findByid(int id){
		// TODO Auto-generated method stub
		System.out.println("按照ID查询业主信息");
		return (Owner)this.getCurSession().createQuery("from Owner where id=?").setParameter(0, id).uniqueResult();
	}
	
	public void update(Owner owner) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Owner o set o.o_name='"+owner.getO_name()+"',o.o_cardnumber='"+owner.getO_cardnumber()+"',o.h_house_number='"+owner.getH_house_number()+"',o.o_phone='"+owner.getO_phone()+"',o.o_time='"+owner.getO_time()+"' where o.o_id='"+owner.getO_id()+"'").executeUpdate();
	}
	
	public void updatestate(Owner owner) {
		// TODO Auto-generated method stub
		System.out.println("准备修改状态");
		this.getCurSession().createQuery("Update Home o set o.h_state= '已入住'  where o.h_house_number='"+owner.getH_house_number()+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Owner> findByCondition_two(String owner_name,String owner_cardnumber,String house_number){
		// TODO Auto-generated method stub
		System.out.println("查询车辆信息中");
		Query query=this.getCurSession().createQuery("from Owner where o_name like '"+"%"+owner_name+"%"+"' and o_cardnumber like '"+"%"+owner_cardnumber+"%"+"' and h_house_number like '"+"%"+house_number+"%"+"'");
		return (List<Owner>)query.list();
	}
	
	public void updateHouseByNum(String house_number){
		System.out.println("删除");
		this.getCurSession().createQuery("Update Home h set h.h_state='待出售'  where h.h_house_number='"+house_number+"'").executeUpdate();
	}
	
	//验证身份证号的唯一性
	public int findCardNum(String CardNum) {
		// TODO Auto-generated method stub
		System.out.println("ready to find");
		int phoneNum=this.getCurSession().createQuery("from Owner where o_cardnumber ='"+CardNum+"'").list().size();
		System.out.println(phoneNum);
		return phoneNum;
	}
}
