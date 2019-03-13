package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IOthApparatus;
import com.lzy.pojo.Otherapparatus;
import com.opensymphony.xwork2.ActionSupport;

public class OthApparatusAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Otherapparatus otherapparatus;
	private IOthApparatus othApparatusDao;
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
	public Otherapparatus getOtherapparatus() {
		return otherapparatus;
	}
	public void setOtherapparatus(Otherapparatus otherapparatus) {
		this.otherapparatus = otherapparatus;
	}
	public IOthApparatus getOthApparatusDao() {
		return othApparatusDao;
	}
	public void setOthApparatusDao(IOthApparatus othApparatusDao) {
		this.othApparatusDao = othApparatusDao;
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
	public String OthApparatusAdd() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("911911911");
		othApparatusDao.add(otherapparatus);
		return "findsuccess";
	}
	
	public String FindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("查询其他信息");
		ServletActionContext.getRequest().getSession()
		.setAttribute("othapparatus", othApparatusDao.findAll());
		System.out.println("查询其他信息完毕");
		return "findsuccess";
	}
	
	public String OthApparatusFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("othapparatus", othApparatusDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(othApparatusDao.getSize()<=15){
			size=1;
		}else{
			if(othApparatusDao.getSize()%15==0){
				size=(int) Math.ceil(othApparatusDao.getSize()/15);
			}else{
				size=(int) Math.ceil(othApparatusDao.getSize()/15+1);	
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
	
	public String OtherapparatusDelete() throws Exception {
		// TODO Auto-generated method stub
		othApparatusDao.delete(id);
		return this.OthApparatusFindAll();
	}
	
	//按照id查询对应信息，为更新准备
	public String OtherapparatusFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("ap", othApparatusDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	
	public String OtherapparatusUpdate() throws Exception {
		// TODO Auto-generated method stub
		othApparatusDao.update(otherapparatus);
		return this.OthApparatusFindAll();
	}
	
	public String OtherapparatusSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("othapparatus",othApparatusDao.findByCondition_two(app_aname,app_name,app_time));
		System.out.println("返回工作人员高级查询");
		return "findsuccess";
	}
}
