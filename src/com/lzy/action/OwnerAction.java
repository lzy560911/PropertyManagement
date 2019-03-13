package com.lzy.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.lzy.dao.IOwner;
import com.lzy.pojo.Owner;
import com.opensymphony.xwork2.ActionSupport;

public class OwnerAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Owner owner;
	private IOwner ownerDao;
	private int id;
	private int page;
	private String owner_name;
	private String owner_cardnumber;
	private String house_number;
	private String CardNum;
	private Map<String, Object> DataMap = new HashMap<String, Object>();
	
	public String getCardNum() {
		return CardNum;
	}
	public void setCardNum(String cardNum) {
		CardNum = cardNum;
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
	public IOwner getOwnerDao() {
		return ownerDao;
	}
	public void setOwnerDao(IOwner ownerDao) {
		this.ownerDao = ownerDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_cardnumber() {
		return owner_cardnumber;
	}
	public void setOwner_cardnumber(String owner_cardnumber) {
		this.owner_cardnumber = owner_cardnumber;
	}
	public String getHouse_number() {
		return house_number;
	}
	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}
	public String OwnerFindAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<Owner> ow = ownerDao.findAll(page,15);
		for(int i=0;i<ow.size();i++){
			ow.get(i).setO_cardnumber(ow.get(0).getO_cardnumber().substring(0,3)+"***********"+ow.get(0).getO_cardnumber().substring(14,18));
			System.out.println("get() is "+ow.get(i).getO_cardnumber());
		}
		ServletActionContext.getRequest().getSession()
		.setAttribute("owner",ow);	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(ownerDao.getSize()<=15){
			size=1;
		}else{
			if(ownerDao.getSize()%15==0){
				size=(int) Math.ceil(ownerDao.getSize()/15);
			}else{
				size=(int) Math.ceil(ownerDao.getSize()/15+1);	
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
	//按照ID删除
	public String OwnerDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备删除业主车辆信息");
		ownerDao.delete(id);
		ownerDao.updateHouseByNum(house_number);
		return this.OwnerFindAll();
	}

	//添加信息
	public String OwnerAdd() throws Exception {
		// TODO Auto-generated method stub
		ownerDao.add(owner);
		return this.OwnerUpdateState();
	}
	
	//更新
	public String OwnerUpdateState() throws Exception {
		// TODO Auto-generated method stub
		ownerDao.updatestate(owner);
		System.out.println("更新状态完毕");
		return this.OwnerFindAll();
	}
	
	
	public String OwnerFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("o", ownerDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	
	//更新
	public String OwnerUpdate() throws Exception {
		// TODO Auto-generated method stub
		ownerDao.update(owner);
		return this.OwnerFindAll();
	}
	
	public String OwnerFindByIdToRepair() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("r", ownerDao.findByid(id));
		return "repair";
	}
	public String OwnerSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("owner",ownerDao.findByCondition_two(owner_name,owner_cardnumber,house_number));
		System.out.println("返回工作人员高级查询");
		return "findsuccess";
	}
	
	public String findCardNum(){
		System.out.println("要查看的身份证号码是："+CardNum);
		int usernum = ownerDao.findCardNum(CardNum);
		if(usernum == 0){
			System.out.println("message is 1 "+usernum);
			DataMap.put("CheckCardNum", "canuse");
			System.out.println("values is "+DataMap.values());
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+usernum);
			DataMap.put("CheckCardNum", "notcanuse");
			System.out.println("values is "+DataMap.values());
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "findCardNum";
	}
}
