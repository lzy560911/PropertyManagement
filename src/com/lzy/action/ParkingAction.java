package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IParking;
import com.lzy.pojo.Parking;
import com.opensymphony.xwork2.ActionSupport;

public class ParkingAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Parking parking;
	private IParking parkingDao;
	private int id;
	private int page;
	private String parking_owner;
	private String parking_house_number;
	private String car_id;
	private int month;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public IParking getParkingDao() {
		return parkingDao;
	}
	public void setParkingDao(IParking parkingDao) {
		this.parkingDao = parkingDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getParking_owner() {
		return parking_owner;
	}
	public void setParking_owner(String parking_owner) {
		this.parking_owner = parking_owner;
	}
	public String getParking_house_number() {
		return parking_house_number;
	}
	public void setParking_house_number(String parking_house_number) {
		this.parking_house_number = parking_house_number;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	//查询全部信息，并且分页显示
	public String ParkingFindAll() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("parking", parkingDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(parkingDao.getSize()<=15){
			size=1;
		}else{
			if(parkingDao.getSize()%15==0){
				size=(int) Math.ceil(parkingDao.getSize()/15);
			}else{
				size=(int) Math.ceil(parkingDao.getSize()/15+1);	
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
	
	//按照id删除车位
	public String ParkingDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入删除");
		parkingDao.delete(id);
		return this.ParkingFindAll();
	}
	//添加车位信息
	public String ParkingAdd() throws Exception {
		// TODO Auto-generated method stub
		parkingDao.add(parking);
		parkingDao.addParkingNum(month);
		return this.ParkingFindAll();
	}
	
	//查询全部信息
	/*public String ParkingFindFree() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入查询空闲");
		ServletActionContext.getRequest().getSession()
		.setAttribute("freeparking", parkingDao.findfree());
		System.out.println("返回查询空闲");
		return "findfreesuccess";
	}*/
	
	public String ParkingFindFree() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("freeparking", parkingDao.findfree(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(parkingDao.getFreeSize()<=15){
			size=1;
		}else{
			if(parkingDao.getFreeSize()%15==0){
				size=(int) Math.ceil(parkingDao.getFreeSize()/15);
			}else{
				size=(int) Math.ceil(parkingDao.getFreeSize()/15+1);	
				}
		}
		ServletActionContext.getRequest().getSession().setAttribute("size", size);
		int[] s =new int[size];
		for(int i=0;i<size;i++){
			
			s[i]=i+1;
		}
		System.out.println(page);
		ServletActionContext.getRequest().getSession().setAttribute("fenye", s);
		return "findfreesuccess";
	}

	//更新
	public String ParkingUpdate() throws Exception {
		// TODO Auto-generated method stub
		parkingDao.update(parking);
		return this.ParkingFindAll();
	}
	//按照id查询对应信息，为更新准备
	public String ParkingFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("p", parkingDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	
	public String ParkingSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(parking_owner);
		System.out.println(parking_house_number);
		System.out.println(car_id);
		ServletActionContext.getRequest().getSession()
		.setAttribute("parking",parkingDao.findByCondition_two(parking_owner,parking_house_number,car_id));
		System.out.println("返回业主车辆查询");
		return "findsuccess";
	}
}
