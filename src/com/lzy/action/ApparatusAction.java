package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IApparatus;
import com.lzy.pojo.Apparatus;
import com.opensymphony.xwork2.ActionSupport;

public class ApparatusAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Apparatus apparatus;
	private IApparatus apparatusDao;
	private int id;
	private int page;
	private String app_aname;
	private String app_name;
	private String app_time;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Apparatus getApparatus() {
		return apparatus;
	}
	public void setApparatus(Apparatus apparatus) {
		this.apparatus = apparatus;
	}
	public IApparatus getApparatusDao() {
		return apparatusDao;
	}
	public void setApparatusDao(IApparatus apparatusDao) {
		this.apparatusDao = apparatusDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApp_aname() {
		return app_aname;
	}
	public void setApp_aname(String app_aname) {
		this.app_aname = app_aname;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getApp_time() {
		return app_time;
	}
	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}
	public String ApparatusAdd() throws Exception {
		// TODO Auto-generated method stub
		apparatusDao.add(apparatus);
		return this.ApparatusFindAll();
	}
	
	public String FindAll() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("apparatus", apparatusDao.findAll());
		return "findsuccess";
	}
	
	public String ApparatusFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("apparatus", apparatusDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(apparatusDao.getSize()<=15){
			size=1;
		}else{
			if(apparatusDao.getSize()%15==0){
				size=(int) Math.ceil(apparatusDao.getSize()/15);
			}else{
				size=(int) Math.ceil(apparatusDao.getSize()/15+1);	
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
	
	
	public String ApparatusDelete() throws Exception {
		// TODO Auto-generated method stub
		apparatusDao.delete(id);
		return this.ApparatusFindAll();
	}
	
	//按照id查询对应信息，为更新准备
	public String ApparatusFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("a", apparatusDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	//更新
	public String ApparatusUpdate() throws Exception {
		// TODO Auto-generated method stub
		apparatusDao.update(apparatus);
		return this.ApparatusFindAll();
	}
	public String ApparatusSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("apparatus",apparatusDao.findByCondition_two(app_aname,app_name,app_time));
		System.out.println("返回工作人员高级查询");
		return "findsuccess";
	}
}
