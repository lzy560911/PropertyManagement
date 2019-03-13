package com.lzy.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.dao.IRepair;
import com.lzy.pojo.MaintenancePayment;
import com.lzy.pojo.Repair;
import com.opensymphony.xwork2.ActionSupport;

public class RepairAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Repair repair;
	private IRepair repairDao;
	private MaintenancePayment maintenancePayment;
	private int id;
	private String search_name;
	private String search_mess;
	private String search_phone;
	
	private String search_oname;//保修凭证业主姓名
	private String search_ophone;//保修凭证业主电话
	private String search_rname;//保修凭证维修人员姓名
	
	public String getSearch_oname() {
		return search_oname;
	}
	public void setSearch_oname(String search_oname) {
		this.search_oname = search_oname;
	}
	public String getSearch_ophone() {
		return search_ophone;
	}
	public void setSearch_ophone(String search_ophone) {
		this.search_ophone = search_ophone;
	}
	public String getSearch_rname() {
		return search_rname;
	}
	public void setSearch_rname(String search_rname) {
		this.search_rname = search_rname;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSearch_mess() {
		return search_mess;
	}
	public void setSearch_mess(String search_mess) {
		this.search_mess = search_mess;
	}
	public String getSearch_phone() {
		return search_phone;
	}
	public void setSearch_phone(String search_phone) {
		this.search_phone = search_phone;
	}
	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	public IRepair getRepairDao() {
		return repairDao;
	}
	public void setRepairDao(IRepair repairDao) {
		this.repairDao = repairDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public MaintenancePayment getMaintenancePayment() {
		return maintenancePayment;
	}
	public void setMaintenancePayment(MaintenancePayment maintenancePayment) {
		this.maintenancePayment = maintenancePayment;
	}
	//查询保修表内全部信息
	public String RepairFindAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入保修信息查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("repair", repairDao.findAll());
		System.out.println("返回保修信息查询");
		return "findsuccess";
	}
	
	//添加保修信息
	public String RepairAdd() throws Exception {
		// TODO Auto-generated method stub
		repairDao.add(repair);
		return "success";
	}
	
	//修改保修信息的状态（由未维修变更至已维修）
	public String RepairUpdateById() throws Exception {
		System.out.println("welcome to update ！");
		repairDao.updateByid(id);
		return this.RepairFindAll();
	}
	
	//查询未完成维修的信息
	public String RepairShowFalse() throws Exception {
		System.out.println("welcome to showfalse！");
		ServletActionContext.getRequest().getSession()
		.setAttribute("false", repairDao.repairShowFalse());
		System.out.println("return false！！");
		return "findfalse";
	}
	//按照ID查询保修信息，为生成凭证做准备
	public String RepairFindById() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("repair", repairDao.findByid(id));
		return "findbyid";
	}
	
	//添加保修信息
	public String RepairPrint() throws Exception {
		// TODO Auto-generated method stub
		repairDao.add_voucher(maintenancePayment);
		return this.RepairUpdateById();
	}
	
	//查询已完成保修的信息，打印凭证
	public String RepairFinFind() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入保修信息查询");
		ServletActionContext.getRequest().getSession()
		.setAttribute("Messprint", repairDao.findSuccessAll());
		System.out.println("返回保修信息查询");
		return "findfinish";
	}
	
	//按照ID查询保修信息，为生成凭证做准备
	public String Printvoucher() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("print", repairDao.printvoucher(id));
		return "print";
	}
	
	public String RepairSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession()
		.setAttribute("repair",repairDao.findByCondition_two(search_name,search_mess,search_phone));
		System.out.println("返回保修高级查询");
		return "findsuccess";
	}
	public String PaymentSearchByCondition() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(search_oname+search_ophone+search_rname);
		ServletActionContext.getRequest().getSession()
		.setAttribute("Messprint",repairDao.findByCondition_three(search_oname,search_ophone,search_rname));
		System.out.println("返回凭证高级查询");
		return "findfinish";
	}
}
