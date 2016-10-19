package com.qinguangfeng.entity819;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 这是 学java 访问数据库 的方法
 * 用JDBC这套接口
 * @author Administrator
 *
 */
public class JDBC {
private static String user ="root";
private static String password ="!Xyj123016";
private static String url ="jdbc:mysql://192.168.0.116:3306/jdbc";
	public static void main(String[] args) throws Exception {
	
			//==动态加载类,这个类 是mysql的驱动类，驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//Class.forName("com.qinguangfeng.entity819.JDBC");
			//==获取连接
			Connection connection=DriverManager.getConnection(url, user, password);
			System.out.println(connection.isClosed());
			System.out.println("连接成功");
			
			
	
		
	}

}
