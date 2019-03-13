package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Administrators;

public interface IAdministrators {
	public List<Administrators> findAll();
	public void delete(int id);
	public List<Administrators> findByphone(String phone,String security);
	public void update(Administrators administrators);
	public Administrators findByid(int id);
	public void add(Administrators administrators);
	public List<Administrators> findme(String me);
}
