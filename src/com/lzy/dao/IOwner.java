package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Owner;

public interface IOwner {
	public List<Owner> findAll(int page,int rows);
	public void delete(int id);
	public void update(Owner owner);
	public void updatestate(Owner owner);
	public Owner findByid(int id);
	public void add(Owner owner);
	public int getSize();
	public void updateHouseByNum(String house_number);
	public List<Owner> findByCondition_two(String owner_name,String owner_cardnumber,String house_number);
	public int findCardNum(String CardNum);
}
