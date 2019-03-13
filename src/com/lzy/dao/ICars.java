package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Cars;

public interface ICars {
	public List<Cars> findAll(int page,int rows);
	public void delete(int id);
	public void update(Cars cars);
	public Cars findByid(int id);
	public void add(Cars cars);
	public int getSize();
	/*public List<Cars> findByCondition(String sql);*/
	public List<Cars> findByCondition_two(String car_name,String car_color,String car_id);
	public void addCarsNum(int month);
	public int findcarNum(String carNum);
}
