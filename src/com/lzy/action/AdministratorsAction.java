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
	
	//��ѯȫ����Ϣ
	public String AdministratorsFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�������Ա��Ϣ��ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("administrators", administratorsDao.findAll());
		System.out.println("���ع���Ա��Ϣ��ѯ");
		return "findsuccess";
	}
	
	//����IDɾ��
	public String AdministratorsDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("׼��ɾ������Ա��Ϣ");
		administratorsDao.delete(id);
		return this.AdministratorsFindAll();
	}
	//�����Ϣ
	public String AdministratorsAdd() throws Exception {
		// TODO Auto-generated method stub
		administratorsDao.add(administrators);
		//return this.AdministratorsFindAll();
		return "addsuccess";
	}
	//����
	public String AdministratorsUpdate() throws Exception {
		// TODO Auto-generated method stub
		administratorsDao.update(administrators);
		return "returnLogin";
	}
	
	public String AdministratorsFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("a", administratorsDao.findByid(id));
		System.out.println("׼�������޸Ľ���");
		System.out.println();
		return "edit";
	}
	
	public String FindPassword() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�����һ�����");
		System.out.println("phone is :"+phone+security);
		List<Administrators> list = administratorsDao.findByphone(phone,security);
		System.out.println("the list is +++"+list);
		ServletActionContext.getRequest().getSession()
		.setAttribute("a",list);
		System.out.println("׼�������һ�����");
		System.out.println();
		return "findpassword";
	}
	
	public String AdministratorsFindMe() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�������Ա��Ϣ��ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("administrators", administratorsDao.findme(me));
		System.out.println("���ع���Ա��Ϣ��ѯ");
		return "findsuccess";
	}
	
}
