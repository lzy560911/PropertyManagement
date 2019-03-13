package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IHome;
import com.lzy.pojo.Home;

public class HomeDao extends HibernateDaoSupport implements IHome{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Home> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询房屋信息中");
		Query query=this.getCurSession().createQuery("from Home");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Home>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Home a ").list().size();
		System.out.println(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<Home> freefindAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询出售房屋信息中");
		Query query=this.getCurSession().createQuery("from Home where h_state='待出售'");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Home>)query.list();
	}
	
	public int getFreeSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Home where h_state='待出售'").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("删除房屋信息");
		Home home=new Home();
		home.setH_id(id);;
		this.getCurSession().delete(home);
	}
	
	public void add(Home home) {
		// TODO Auto-generated method stub
		this.getCurSession().save(home);
	}
	
	public Home findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询房屋信息");
		return (Home)this.getCurSession().createQuery("from Home where id=?").setParameter(0, id).uniqueResult();
	}
	public void update(Home home) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Home h set h.h_house_number='"+home.getH_house_number()+"',h.h_state='"+home.getH_state()+"' where h.h_id='"+home.getH_id()+"'").executeUpdate();
	}
	
	//当删除房屋信息时把对应的业主信息一并删除
	public void delOwnerByHouseNum(String houseNum){
		System.out.println("删除房屋信息时删除业主信息");
		this.getCurSession().createQuery("delete Owner where h_house_number='"+houseNum+"'").executeUpdate();
	}

	public int findHouNum(String houseNum) {
		// TODO Auto-generated method stub
		System.out.println("ready to find");
		int hNum=this.getCurSession().createQuery("from Home where h_house_number ='"+houseNum+"'").list().size();
		System.out.println(hNum);
		return hNum;
	}
	
}
