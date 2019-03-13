package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Owner;

public interface IMoney {
	public List<Owner> findAll(int page,int rows);
	public List<Owner> findAlready(int page,int rows);
	public void update(Owner owner);
	public Owner findByid(int id);	
	public Owner findByHomeNumber(String homenumber);
	public int getSize();
	public int getReadySize();
	public List<Owner> findByCondition_two(String search_num,String search_name);
}
