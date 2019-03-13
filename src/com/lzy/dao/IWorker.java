package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Worker;

public interface IWorker {
	public void add(Worker worker);
	public List<Worker> findAll(int page,int rows);
	public void delete(int id);
	public void update(Worker woeker);
	public Worker findByid(int id);	
	public int getSize();
	public List<Worker> findByCondition_two(String worker_name,String work_cardnumber,String work_dname);
}
