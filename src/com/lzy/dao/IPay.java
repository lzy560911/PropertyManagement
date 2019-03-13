package com.lzy.dao;

import com.lzy.pojo.Pay;

public interface IPay {
	public void add(Pay pay);
	public void update(Pay pay);
	public Pay printvoucher(String h_house_number);
}
