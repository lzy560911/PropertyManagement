package com.lzy.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IHome;
import com.lzy.pojo.Home;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Home home;
	private IHome homeDao;
	private int id;
	private int page;
	private String houseNum;
	private Map<String, Object> DataMap = new HashMap<String, Object>();
	
	
	public Map<String, Object> getDataMap() {
		return DataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		DataMap = dataMap;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	public IHome getHomeDao() {
		return homeDao;
	}
	public void setHomeDao(IHome homeDao) {
		this.homeDao = homeDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//查询全部信息
	/*public String HomeFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入业主车辆查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("home", homeDao.findAll());
		System.out.println("返回业主车辆查询");
		return "findsuccess";
	}*/
	public String HomeFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("home", homeDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(homeDao.getSize()<=15){
			size=1;
		}else{
			if(homeDao.getSize()%15==0){
				size=(int) Math.ceil(homeDao.getSize()/15);
			}else{
				size=(int) Math.ceil(homeDao.getSize()/15+1);	
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
	
	/*public String FreeHomeFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入闲置房屋");
		ServletActionContext.getRequest().getSession()
		.setAttribute("freehome", homeDao.freefindAll());
		System.out.println("返回闲置房屋查询");
		return "freefindsuccess";
	}*/
	public String FreeHomeFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("freehome", homeDao.freefindAll(page,5));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(homeDao.getFreeSize()<=5){
			size=1;
		}else{
			if(homeDao.getFreeSize()%5==0){
				size=(int) Math.ceil(homeDao.getFreeSize()/5);
			}else{
				size=(int) Math.ceil(homeDao.getFreeSize()/5+1);	
				}
		}
		ServletActionContext.getRequest().getSession().setAttribute("size", size);
		int[] s =new int[size];
		for(int i=0;i<size;i++){
			
			s[i]=i+1;
		}
		System.out.println(page);
		ServletActionContext.getRequest().getSession().setAttribute("fenye", s);
		return "freefindsuccess";
	}
	
	//按照ID删除
	public String HomeDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备删除房屋信息");
		homeDao.delete(id);
		homeDao.delOwnerByHouseNum(houseNum);
		return this.HomeFindAll();
	}
	//添加信息
	public String HomeAdd() throws Exception {
		// TODO Auto-generated method stub
		homeDao.add(home);
		return this.FreeHomeFindAll();
	}
	
	//按照id查询对应房屋
	public String HomeFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("h", homeDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	//更新
	public String HomeUpdate() throws Exception {
		// TODO Auto-generated method stub
		homeDao.update(home);
		return this.HomeFindAll();
	}
	
	/*//查询全部信息
	public String OwnerFindHomeNum() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入业主查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("num", homeDao.findAll());
		System.out.println("返回业主查询");
		return "findnumsuccess";
	}*/
	//查询门牌号是否存在
	public String findHouseNum(){
		System.out.println("要查看的门牌号码："+houseNum);
		int usernum = homeDao.findHouNum(houseNum);
		if(usernum == 0){
			System.out.println("message is 1 "+houseNum);
			DataMap.put("CheckCardNum", "bucunzai");
			System.out.println("values is "+DataMap.values());
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+houseNum);
			DataMap.put("CheckCardNum", "yicunzai");
			System.out.println("values is "+DataMap.values());
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "findHouNum";
	}
}
