package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.ICars;
import com.lzy.pojo.Cars;


public class CarsDao extends HibernateDaoSupport implements ICars{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Cars> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询车辆信息中");
		Query query=this.getCurSession().createQuery("from Cars");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Cars>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Cars a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("删除业主车辆信息");
		Cars cars=new Cars();
		cars.setOc_id(id);;
		this.getCurSession().delete(cars);
	}
	public void update(Cars cars) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Cars p set p.oc_name='"+cars.getOc_name()+"',p.oc_color='"+cars.getOc_color()+"',p.oc_licenseplate='"+cars.getOc_licenseplate()+"' where p.oc_id='"+cars.getOc_id()+"'").executeUpdate();
	}
	public Cars findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询汽车信息");
		return (Cars)this.getCurSession().createQuery("from Cars where id=?").setParameter(0, id).uniqueResult();
	}
	
	public void add(Cars cars) {
		// TODO Auto-generated method stub
		this.getCurSession().save(cars);
	}
	
	/*@SuppressWarnings("unchecked")
	public List<Cars> findByCondition(String sql) {
		// TODO Auto-generated method stub
		System.out.println("welcome to DAO "+sql);
		System.out.println("查询车辆信息中");
		Query Conditionquery=this.getCurSession().createSQLQuery(sql);
		System.out.println("result is "+Conditionquery.list().size());
		return (List<Cars>)Conditionquery.list();
	}*/
	
	@SuppressWarnings("unchecked")
	public List<Cars> findByCondition_two(String car_name,String car_color,String car_id){
		// TODO Auto-generated method stub
		System.out.println("查询车辆信息中");
		Query query=this.getCurSession().createQuery("from Cars where oc_name like '"+"%"+car_name+"%"+"' and oc_color like '"+"%"+car_color+"%"+"' and oc_licenseplate like '"+"%"+car_id+"%"+"'");
		return (List<Cars>)query.list();
	}
	
	public void addCarsNum(int month){
		System.out.println("即将更新+1");
		this.getCurSession().createQuery("Update Carsnum p set p.car_num=p.car_num+1  where p.id='"+month+"'").executeUpdate();
		System.out.println("完成更新+1");
	}
	public int findcarNum(String carNum) {
		// TODO Auto-generated method stub
		System.out.println("ready to find");
		int cNum=this.getCurSession().createQuery("from Cars where oc_licenseplate ='"+carNum+"'").list().size();
		System.out.println(cNum);
		return cNum;
	}
}
