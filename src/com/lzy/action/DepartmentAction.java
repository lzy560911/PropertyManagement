package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IDepartment;
import com.lzy.pojo.Department;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department;
	private IDepartment departmentDao;
	private int id;
	private int page;
	private String departmentName;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public IDepartment getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(IDepartment departmentDao) {
		this.departmentDao = departmentDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//查询全部信息
/*		public String DepartmentFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("查询部门信息");
		ServletActionContext.getRequest().getSession()
		.setAttribute("department", departmentDao.findAll());
		System.out.println("查询部门信息完毕");
		return "findsuccess";
	}*/
	
		public String DepartmentFindAll() throws Exception {
			// TODO Auto-generated method stub
			
			ServletActionContext.getRequest().getSession()
			.setAttribute("department", departmentDao.findAll(page,15));	
			ServletActionContext.getRequest().getSession().setAttribute("page",page);
			int size=0;
			if(departmentDao.getSize()<=15){
				size=1;
			}else{
				if(departmentDao.getSize()%15==0){
					size=(int) Math.ceil(departmentDao.getSize()/15);
				}else{
					size=(int) Math.ceil(departmentDao.getSize()/15+1);	
					}
			}
			ServletActionContext.getRequest().getSession().setAttribute("size", size);
			int[] s =new int[size];
			for(int i=0;i<size;i++){
				
				s[i]=i+1;
			}
			System.out.println(page);
			ServletActionContext.getRequest().getSession().setAttribute("fenye", s);
			return "findsuccess";
		}
		
		//添加信息
		public String DepartmentAdd() throws Exception {
			// TODO Auto-generated method stub
			departmentDao.add(department);
			return this.DepartmentFindAll();
		}
		
		//按照ID删除
		public String DepartmentDelete() throws Exception {
			// TODO Auto-generated method stub
			departmentDao.delete(id);
			departmentDao.updateWorkerByDepName(departmentName);
			return this.DepartmentFindAll();
		}
		
		//更新
		public String DepartmentUpdate() throws Exception {
			// TODO Auto-generated method stub
			departmentDao.update(department);
			return this.DepartmentFindAll();
		}
		public String DepartmentFindById() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("进入findbyid");
			ServletActionContext.getRequest().getSession()
			.setAttribute("d", departmentDao.findByid(id));
			System.out.println("准备返回修改界面");
			System.out.println();
			return "edit";
		}
}
