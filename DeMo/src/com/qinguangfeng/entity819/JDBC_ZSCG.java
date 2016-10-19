package com.qinguangfeng.entity819;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 这是 是在 测试 之前JDBC 已经获取连接 的基础上
 * 进一步 用java 对数据库 进行增删查改的类
 * @author Administrator
 *
 */
public class JDBC_ZSCG {
	private static String user ="root";
	private static String password ="!Xyj123016";
	private static String bianma="?useUnicode=true&characterEncoding=uft8";
	private static String url ="jdbc:mysql://192.168.0.116:3306/jdbc";

	/**
	 *  	private static String url ="jdbc:mysql://127.0.0.1:3306/studb";
	 *  如果发到别人的 那里，乱码的话，在库名后面。加上" ？useUnicode=true &characterEncoding=uft8"
	 */
	private static Statement statement;
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url, user, password);
			/**增加方法
			 * String add="Insert Into grade(gradeid,gradename) Values ('3','.net')";
			 */
			//String add="Insert Into use_info(username,password) Values ('覃光峰','123')";
			
			
			/**
			 * 修改方法
			 * String update="Update grade set gradename='c' where gradename='c++'";
			 */
			statement=connection.createStatement();
			
			
			 String select="Select id,username,password from user_info";
			 
			ResultSet result=statement.executeQuery(select);
			while(result.next()){
				
				System.out.println("id:"+result.getInt("id")+"\tusername:"+result.getString("username")+"\tpassword:"+result.getString("password"));
			}
			
			
			
			
			/**删除方法
			 * String delect="Delect  from grade where grade.gradeid='1'";
			 */
			
			
			
			
			//==以下创建一个 statment对象，以上要 声明一个 statment的静态Statment类型 的变量
		
			
			//==用.executeUpdate这个方法，可以完成 增、删、改 的操作
			 
	      // int result=	statement.executeUpdate(add);
		
		//	 System.out.println(result);
		//System.out.println("受影响了"+result+"行！");
		statement.close();
		connection.close();
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		
		
	}

}
