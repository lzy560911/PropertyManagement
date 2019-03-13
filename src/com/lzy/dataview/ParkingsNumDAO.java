package com.lzy.dataview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lzy.pojo.Parkingsnum;


public class ParkingsNumDAO {
	Connection connection;

	public Connection getConnection() {
		try {
			String name = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/lzy_property_manager";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Parkingsnum> listAll() {
		ArrayList<Parkingsnum> list = new ArrayList<Parkingsnum>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = this.getConnection().prepareStatement("SELECT * FROM a_parkings_num");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Parkingsnum barEvaporation = new Parkingsnum();
				barEvaporation.setParkings_num((rs.getString("parkings_num")));
				list.add(barEvaporation);
				System.out.println("连接数据库成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
