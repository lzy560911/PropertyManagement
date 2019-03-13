package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IMoney;
import com.lzy.pojo.Owner;
import com.opensymphony.xwork2.ActionSupport;

public class MoneyAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Owner owner;
	private IMoney moneyDao;
	private int id;
	private int page;
	private String homenumber;
	private String search_num;
	private String search_name;
	
	
	public String getSearch_num() {
		return search_num;
	}
	public void setSearch_num(String search_num) {
		this.search_num = search_num;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public IMoney getMoneyDao() {
		return moneyDao;
	}
	public void setMoneyDao(IMoney moneyDao) {
		this.moneyDao = moneyDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getHomenumber() {
		return homenumber;
	}
	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}
	//��ѯȫ����Ϣ
	/*public String MoneyFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ˮ��Ѳ�ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("money", moneyDao.findAll());
		System.out.println("����ˮ��Ѳ�ѯ");
		return "findsuccess";
	}*/
	public String MoneyFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("money", moneyDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(moneyDao.getSize()<=15){
			size=1;
		}else{
			if(moneyDao.getSize()%15==0){
				size=(int) Math.ceil(moneyDao.getSize()/15);
			}else{
				size=(int) Math.ceil(moneyDao.getSize()/15+1);	
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
	
	//��ѯȫ����Ϣ
	/*public String MoneyAlready() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ˮ��Ѳ�ѯ");
		ServletActionContext.getRequest().getSession()
		.setAttribute("moneyready", moneyDao.findAlready());
		System.out.println("����ˮ��Ѳ�ѯ");
		return "findreadysuccess";
	}*/
	
	public String MoneyAlready() throws Exception {
		// TODO Auto-generated method stub
		
		ServletActionContext.getRequest().getSession()
		.setAttribute("moneyready", moneyDao.findAlready(page,5));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(moneyDao.getReadySize()<=5){
			size=1;
		}else{
			if(moneyDao.getReadySize()%5==0){
				size=(int) Math.ceil(moneyDao.getReadySize()/5);
			}else{
				size=(int) Math.ceil(moneyDao.getReadySize()/5+1);	
				}
		}
		ServletActionContext.getRequest().getSession().setAttribute("size", size);
		int[] s =new int[size];
		for(int i=0;i<size;i++){
			
			s[i]=i+1;
		}
		System.out.println(page);
		ServletActionContext.getRequest().getSession().setAttribute("fenye", s);
		return "findreadysuccess";
	}
	
	//����id��ѯ��Ӧ��Ϣ��Ϊ����׼��
	public String MoneyFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("m", moneyDao.findByid(id));
		System.out.println("׼����ҵ��������Ϣ���ؽɷѽ��棬����ɷѺ����ɷ�ƾ֤����");
		System.out.println();
		return "findmoney";
	}
	//����ҵ�����ƺŲ�ѯҵ����Ϣ�����ص�ҵ���ɷѽ�����
	public String MoneyFindByHomeNumber() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("m", moneyDao.findByHomeNumber(homenumber));
		System.out.println("׼����ҵ��������Ϣ���ؽɷѽ��棬����ɷѺ����ɷ�ƾ֤����");
		System.out.println();
		return "findmoney";
	}
	
	public String MoneySearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("search_num is "+search_num);
		System.out.println("search_name"+search_name);
		ServletActionContext.getRequest().getSession()
		.setAttribute("money",moneyDao.findByCondition_two(search_num,search_name));
		System.out.println("���ؽɷѲ�ѯ");
		return "findsuccess";
	}
}
