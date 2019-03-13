package com.lzy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IAdministrators;
import com.lzy.pojo.Administrators;
import com.opensymphony.xwork2.ActionSupport;

public class AdministratorsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Administrators administrators;
	private IAdministrators administratorsDao;
	private int id;
	private String phone;
	private String security;
	private String me;
	
	
	public String getMe() {
		return me;
	}
	public void setMe(String me) {
		this.me = me;
	}
	public Administrators getAdministrators() {
		return administrators;
	}
	public void setAdministrators(Administrators administrators) {
		this.administrators = administrators;
	}
	public IAdministrators getAdministratorsDao() {
		return administratorsDao;
	}
	public void setAdministratorsDao(IAdministrators administratorsDao) {
		this.administratorsDao = administratorsDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	
	//查询全部信息
	public String AdministratorsFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入管理员信息查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("administrators", administratorsDao.findAll());
		System.out.println("返回管理员信息查询");
		return "findsuccess";
	}
	
	//按照ID删除
	public String AdministratorsDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备删除管理员信息");
		administratorsDao.delete(id);
		return this.AdministratorsFindAll();
	}
	//添加信息
	public String AdministratorsAdd() throws Exception {
		// TODO Auto-generated method stub
		administratorsDao.add(administrators);
		//return this.AdministratorsFindAll();
		return "addsuccess";
	}
	//更新
	public String AdministratorsUpdate() throws Exception {
		// TODO Auto-generated method stub
		administratorsDao.update(administrators);
		return "returnLogin";
	}
	
	public String AdministratorsFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("a", administratorsDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	
	public String FindPassword() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入找回密码");
		System.out.println("phone is :"+phone+security);
		List<Administrators> list = administratorsDao.findByphone(phone,security);
		System.out.println("the list is +++"+list);
		ServletActionContext.getRequest().getSession()
		.setAttribute("a",list);
		System.out.println("准备返回找回密码");
		System.out.println();
		return "findpassword";
	}
	
	public String AdministratorsFindMe() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入管理员信息查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("administrators", administratorsDao.findme(me));
		System.out.println("返回管理员信息查询");
		return "findsuccess";
	}
	
}
