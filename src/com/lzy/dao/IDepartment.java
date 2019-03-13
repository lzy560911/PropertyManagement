package com.lzy.dao;

import java.util.List;

import com.lzy.pojo.Department;

public interface IDepartment {

	public void add(Department department);
	public List<Department> findAll(int page,int rows);
	public void delete(int id);
	public void update(Department department);
	public Department findByid(int id);
	public int getSize();
	public void updateWorkerByDepName(String departmentName);
}
