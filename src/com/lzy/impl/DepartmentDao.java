package com.lzy.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzy.dao.IDepartment;
import com.lzy.pojo.Department;

public class DepartmentDao extends HibernateDaoSupport implements IDepartment{
	private Session getCurSession(){
		return super.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Department> findAll(int page,int rows) {
		// TODO Auto-generated method stub
		System.out.println("查询部门信息中");
		Query query=this.getCurSession().createQuery("from Department");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return (List<Department>)query.list();
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		int t=this.getCurSession().createQuery("from Department a ").list().size();
		System.out.println(t);
		return t;
	}
	
	public void add(Department department) {
		// TODO Auto-generated method stub
		this.getCurSession().save(department);
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Department department=new Department();
		department.setD_id(id);
		this.getCurSession().delete(department);
	}
	public void update(Department department) {
		// TODO Auto-generated method stub
		System.out.println("准备修改部门信息喽");
		this.getCurSession().createQuery("Update Department d set d.d_name='"+department.getD_name()+"',d.d_leader='"+department.getD_leader()+"',d.d_phone='"+department.getD_phone()+"' where d.d_id='"+department.getD_id()+"'").executeUpdate();
	}
	public Department findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("按照ID查询部门信息");
		return (Department)this.getCurSession().createQuery("from Department where id=?").setParameter(0, id).uniqueResult();
	}
	
	//删除部门信息时，把该部门下的员工所属部门修改为暂未分配
	public void updateWorkerByDepName(String departmentName){
		System.out.println("修改员工所属部门状态");
		this.getCurSession().createQuery("Update Worker w set w.d_name='暂未分配'  where w.d_name='"+departmentName+"'").executeUpdate();
	}
	
}
