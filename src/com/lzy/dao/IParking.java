package com.lzy.dao;

import java.util.List;
import com.lzy.pojo.Parking;

public interface IParking {
	public void add(Parking parking);
	public List<Parking> findAll(int page,int rows);
	public List<Parking> findfree(int page,int rows);
	public void delete(int id);
	public void update(Parking parking);
	public Parking findByid(int id);
	public int getSize();
	public int getFreeSize();
	public List<Parking> findByCondition_two(String parking_owner,String parking_house_number,String car_id);
	public void addParkingNum(int month);

}
