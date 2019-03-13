package com.lzy.dao;

import java.util.List;
import com.lzy.pojo.Administrators;

public interface ILoginUser {
	public List<Administrators> checkname();
	public int findUserName(String Username);
	public int findPhone(String Phone);
}
