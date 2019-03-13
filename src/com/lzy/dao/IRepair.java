package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.MaintenancePayment;
import com.lzy.pojo.Repair;

public interface IRepair {
	public void add(Repair repair);
	public void updateByid(int id);
	public List<Repair> findAll();
	public List<Repair> repairShowFalse();
	public List<Repair>findByCondition_two(String search_name,String search_mess,String search_phone);
	public List<MaintenancePayment>findByCondition_three(String search_oname,String search_ophone,String search_rname);
	public Repair findByid(int id);
	public void add_voucher(MaintenancePayment maintenancePayment);
	public List<MaintenancePayment> findSuccessAll();
	public MaintenancePayment printvoucher(int id);
}
