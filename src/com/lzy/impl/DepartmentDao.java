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
		System.out.println("��ѯ������Ϣ��");
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
		System.out.println("׼���޸Ĳ�����Ϣ�");
		this.getCurSession().createQuery("Update Department d set d.d_name='"+department.getD_name()+"',d.d_leader='"+department.getD_leader()+"',d.d_phone='"+department.getD_phone()+"' where d.d_id='"+department.getD_id()+"'").executeUpdate();
	}
	public Department findByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("����ID��ѯ������Ϣ");
		return (Department)this.getCurSession().createQuery("from Department where id=?").setParameter(0, id).uniqueResult();
	}
	
	//ɾ��������Ϣʱ���Ѹò����µ�Ա�����������޸�Ϊ��δ����
	public void updateWorkerByDepName(String departmentName){
		System.out.println("�޸�Ա����������״̬");
		this.getCurSession().createQuery("Update Worker w set w.d_name='��δ����'  where w.d_name='"+departmentName+"'").executeUpdate();
	}
	
}
