package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Home;

public interface IHome {
	public List<Home> findAll(int page,int rows);
	public List<Home> freefindAll(int page,int rows);
	public void delete(int id);
	public void add(Home home);
	public Home findByid(int id);
	public void update(Home home);
	public int getSize();
	public int getFreeSize();
	public void delOwnerByHouseNum(String houseNum);
	public int findHouNum(String houseNum);
}
