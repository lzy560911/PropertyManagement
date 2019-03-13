package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Otherapparatus;

//其他公共设施
public interface IOthApparatus {
	public void add(Otherapparatus otherapparatus);
	public List<Otherapparatus> findAll(int page,int rows);
	public List<Otherapparatus> findAll();
	public void delete(int id);
	public Otherapparatus findByid(int id);
	public void update(Otherapparatus otherapparatus);
	public int getSize();
	public List<Otherapparatus> findByCondition_two(String app_aname,String app_name,String app_time);
}
