package com.lzy.dao;

import java.util.List;
import com.lzy.pojo.Camera;

//涉及到关于摄像头的操作接口
public interface ICamera {
	public void add(Camera camera);
	public List<Camera> findAll(int page,int rows);
	public List<Camera> findAll();
	public void delete(int id);
	public void update(Camera camera);
	public Camera findByid(int id);
	public int getSize();
	public List<Camera> findByCondition_two(String camera_gbid,String camera_name,String camera_time);
	//public int findGBNum(int gbid);
}
