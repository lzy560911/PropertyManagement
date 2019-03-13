package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Apparatus;


//涉及到关于健身器的操作接口
public interface IApparatus {
	public void add(Apparatus apparatus);
	public List<Apparatus> findAll(int page,int rows);
	public List<Apparatus> findAll();
	public void delete(int id);
	public Apparatus findByid(int id);
	public void update(Apparatus apparatus);
	public int getSize();
	public List<Apparatus> findByCondition_two(String app_aname,String app_name,String app_time);
}
