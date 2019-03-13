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
	//��ѯȫ����Ϣ
	/*public String HomeFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ҵ��������ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("home", homeDao.findAll());
		System.out.println("����ҵ��������ѯ");
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
		System.out.println("�������÷���");
		ServletActionContext.getRequest().getSession()
		.setAttribute("freehome", homeDao.freefindAll());
		System.out.println("�������÷��ݲ�ѯ");
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
	
	//����IDɾ��
	public String HomeDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("׼��ɾ��������Ϣ");
		homeDao.delete(id);
		homeDao.delOwnerByHouseNum(houseNum);
		return this.HomeFindAll();
	}
	//�����Ϣ
	public String HomeAdd() throws Exception {
		// TODO Auto-generated method stub
		homeDao.add(home);
		return this.FreeHomeFindAll();
	}
	
	//����id��ѯ��Ӧ����
	public String HomeFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("h", homeDao.findByid(id));
		System.out.println("׼�������޸Ľ���");
		System.out.println();
		return "edit";
	}
	//����
	public String HomeUpdate() throws Exception {
		// TODO Auto-generated method stub
		homeDao.update(home);
		return this.HomeFindAll();
	}
	
	/*//��ѯȫ����Ϣ
	public String OwnerFindHomeNum() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ҵ����ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("num", homeDao.findAll());
		System.out.println("����ҵ����ѯ");
		return "findnumsuccess";
	}*/
	//��ѯ���ƺ��Ƿ����
	public String findHouseNum(){
		System.out.println("Ҫ�鿴�����ƺ��룺"+houseNum);
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
		System.out.println("׼������");
		return "findHouNum";
	}
}
