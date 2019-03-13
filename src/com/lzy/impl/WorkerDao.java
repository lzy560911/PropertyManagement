package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lzy.dao.IWorker;
import com.lzy.pojo.Worker;


public class WorkerDao extends HibernateDaoSupport implements IWorker{

	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Worker> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询摄像头信息中");
		Query query=this.getCurSession().createQuery("from Worker");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Worker>)query.list();
	}
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Worker a ").list().size();
		System.out.println(t);
		return t;
	}
	//更新员工信息
	public void update(Worker worker) {
		// TODO Auto-generated method stub
		System.out.println("准备修改员工信息喽");
		this.getCurSession().createQuery("Update Worker d set d.w_name='"+worker.getW_name()+"',d.w_sex='"+worker.getW_sex()+"',d.w_cardnumber='"+worker.getW_cardnumber()+"',d.w_phone='"+worker.getW_phone()+"',d.d_name='"+worker.getD_name()+"' where d.w_id='"+worker.getW_id()+"'").executeUpdate();
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("删除业主车辆信息");
		Worker worker=new Worker();
		worker.setW_id(id);
		this.getCurSession().delete(worker);
	}
	
	public void add(Worker worker) {
		// TODO Auto-generated method stub
		this.getCurSession().save(worker);
	}
	
	public Worker findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询员工");
		return (Worker)this.getCurSession().createQuery("from Worker where id=?").setParameter(0, id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Worker> findByCondition_two(String worker_name,String work_cardnumber,String work_dname){
		// TODO Auto-generated method stub
		System.out.println("高级查询");
		Query query=this.getCurSession().createQuery("from Worker where w_name like '"+"%"+worker_name+"%"+"' and w_cardnumber like '"+"%"+work_cardnumber+"%"+"' and d_name like '"+"%"+work_dname+"%"+"'");
		return (List<Worker>)query.list();
	}
}
