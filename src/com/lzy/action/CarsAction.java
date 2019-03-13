package com.lzy.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.lzy.dao.ICars;
import com.lzy.pojo.Cars;
import com.opensymphony.xwork2.ActionSupport;

public class CarsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cars cars;
	private ICars carsDao;
	private int id;
	private int page;
	private String sql;
	private String car_name;
	private String car_color;
	private String car_id;
	private int month;
	private String carNum;
	private Map<String, Object> DataMap = new HashMap<String, Object>();
	
	
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Cars getCars() {
		return cars;
	}
	public void setCars(Cars cars) {
		this.cars = cars;
	}
	public ICars getCarsDao() {
		return carsDao;
	}
	public void setCarsDao(ICars carsDao) {
		this.carsDao = carsDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
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
	public String CarsFindAll() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("cars", carsDao.findAll(page,15));	
		ServletActionContext.getRequest().getSession().setAttribute("page",page);
		int size=0;
		if(carsDao.getSize()<=15){
			size=1;
		}else{
			if(carsDao.getSize()%15==0){
				size=(int) Math.ceil(carsDao.getSize()/15);
			}else{
				size=(int) Math.ceil(carsDao.getSize()/15+1);	
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
	public String CarsDelete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备删除业主车辆信息");
		carsDao.delete(id);
		return this.CarsFindAll();
	}
	
	//更新
	public String CarsUpdate() throws Exception {
		// TODO Auto-generated method stub
		carsDao.update(cars);
		return this.CarsFindAll();
	}
	public String CarsFindById() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入findbyid");
		ServletActionContext.getRequest().getSession()
		.setAttribute("c", carsDao.findByid(id));
		System.out.println("准备返回修改界面");
		System.out.println();
		return "edit";
	}
	//添加信息
	public String CarsAdd() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("当前是"+month+"月份");
		carsDao.add(cars);
		System.out.println("准备为该月车辆数目加1");
		carsDao.addCarsNum(month);
		return this.CarsFindAll();
	}
	
/*	//多条件查询车辆信息
	public String CarsSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("多条件查询....");
		System.out.println("sql is "+sql);
		ServletActionContext.getRequest().getSession()
		.setAttribute("conditioncars",carsDao.findByCondition(sql));
		System.err.println(carsDao.findByCondition(sql).size());
		System.out.println("返回业主车辆查询");
		return "findcondition";
	}*/
	
	//多条件查询车辆信息
	public String CarsSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("car_name is "+car_name);
		System.out.println("car_color"+car_color);
		ServletActionContext.getRequest().getSession()
		.setAttribute("conditioncars",carsDao.findByCondition_two(car_name,car_color,car_id));
		System.out.println("返回业主车辆查询");
		return "findcondition";
	}
	public String findCarsNum(){
		System.out.println("要查看的身份证号码是："+carNum);
		int usernum = carsDao.findcarNum(carNum);
		if(usernum == 0){
			System.out.println("message is 1 "+usernum);
			DataMap.put("CheckCarNum", "ziye");
			System.out.println("values is "+DataMap.values());
			System.out.println("true");
		}else{
			System.out.println("message is 2 "+usernum);
			DataMap.put("CheckCarNum", "ruolin");
			System.out.println("values is "+DataMap.values());
			System.out.println("false");
		}
		System.out.println("准备返回");
		return "findCarNum";
	}
}
