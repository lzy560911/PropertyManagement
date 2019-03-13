package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.ICamera;
import com.lzy.pojo.Camera;


public class CameraDao extends HibernateDaoSupport implements ICamera {
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}

	public void add(Camera camera) {
		// TODO Auto-generated method stub
		this.getCurSession().save(camera);
	}
	
	@SuppressWarnings("unchecked")
	public List<Camera> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询摄像头信息中");
		Query query=this.getCurSession().createQuery("from Camera");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Camera>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Camera> findAll() {
		// TODO Auto-generated method stub
		Query query=this.getCurSession().createQuery("from Camera");
		return (List<Camera>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Camera a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Camera camera=new Camera();
		camera.setC_id(id);
		this.getCurSession().delete(camera);
	}
	
	public void update(Camera camera) {
		// TODO Auto-generated method stub
		System.out.println("准备修改喽");
		this.getCurSession().createQuery("Update Camera c set c.c_gbid='"+camera.getC_gbid()+"',c.c_name='"+camera.getC_name()+"',c.c_state='"+camera.getC_state()+"',c.c_time='"+camera.getC_time()+"' where c.c_id='"+camera.getC_id()+"'").executeUpdate();
	}
	
	public Camera findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询摄像头信息");
		return (Camera)this.getCurSession().createQuery("from Camera where id=?").setParameter(0, id).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Camera> findByCondition_two(String camera_gbid,String camera_name,String camera_time){
		// TODO Auto-generated method stub
		System.out.println("多条件查询摄像头信息中"+camera_name);
		Query query=this.getCurSession().createQuery("from Camera where c_gbid like '"+"%"+camera_gbid+"%"+"' and c_name like '"+"%"+camera_name+"%"+"' and c_time like '"+"%"+camera_time+"%"+"'");
		return (List<Camera>)query.list();
	}

	/*public int findGBNum(int gbid) {
		// TODO Auto-generated method stub
		int gbNum=this.getCurSession().createQuery("from Camera a where c_gbid ='"+gbid+"'").list().size();
		System.out.println(gbNum);
		return gbNum;
	}*/
}
