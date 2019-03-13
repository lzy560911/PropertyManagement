package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IParking;
import com.lzy.pojo.Parking;

public class ParkingDao extends HibernateDaoSupport implements IParking{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Parking> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询车位信息中");
		Query query=this.getCurSession().createQuery("from Parking");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Parking>)query.list();
	}
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Parking a ").list().size();
		System.out.println(t);
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parking> findfree(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询空闲车位信息中");
		Query query=this.getCurSession().createQuery("from Parking where p_name='0'");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Parking>)query.list();
	}
	
	public int getFreeSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Parking where p_name='0'").list().size();
		System.out.println(t);
		return t;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Parking parking=new Parking();
		parking.setP_id(id);
		this.getCurSession().delete(parking);
	}
	
	public void add(Parking parking) {
		// TODO Auto-generated method stub
		this.getCurSession().save(parking);
	}
	
	public Parking findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询摄像头信息");
		return (Parking)this.getCurSession().createQuery("from Parking where id=?").setParameter(0, id).uniqueResult();
	}
	
	public void update(Parking parking) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Parking p set p.p_name='"+parking.getP_name()+"',p.h_house_number='"+parking.getH_house_number()+"',p.p_time='"+parking.getP_time()+"',p.oc_licenseplate='"+parking.getOc_licenseplate()+"' where p.p_id='"+parking.getP_id()+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Parking> findByCondition_two(String parking_owner,String parking_house_number,String car_id){
		// TODO Auto-generated method stub
		System.out.println("查询车辆信息中");
		Query query=this.getCurSession().createQuery("from Parking where p_name like '"+"%"+parking_owner+"%"+"' and h_house_number like '"+"%"+parking_house_number+"%"+"' and oc_licenseplate like '"+"%"+car_id+"%"+"'");
		return (List<Parking>)query.list();
	}
	public void addParkingNum(int month){
		System.out.println("即将更新+1");
		this.getCurSession().createQuery("Update Parkingsnum p set p.parkings_num=p.parkings_num+1  where p.id='"+month+"'").executeUpdate();
		System.out.println("完成更新+1");
	}
}
