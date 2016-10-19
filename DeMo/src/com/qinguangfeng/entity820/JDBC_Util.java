package com.qinguangfeng.entity820;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Properties;

/**
 * 这是 要把 昨天 写的 很多JDBC的 重复内容 写到 一个工具类 和 配置文件xml里面，好下次直接使用
 * 
 * @author Administrator
 *
 */
public class JDBC_Util {

	/**
	 * 测试 System.out.println(properties.getProperty("mysqlName")); 是否可以 获取
	 * 我的配置文件 里面的内容 public static void main(String[] args) {
	 * JDBC_Util.getConnection(); }
	 */

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	// ==工具类的方法 你要设置公共的啊，私有的 你让别人调什么啊
	public static Connection getConnection() {
		try {
			Properties properties = new Properties();
			// ==获取一个类 的 获取输入流 的这个方法 的 丢一个 配置文件,路径 最好放在 和类相同 的包里面
			InputStream inStream = JDBC_Util.class.getResourceAsStream("JDBCUtil.propertites");

			properties.load(inStream);
			// System.out.println(properties.getProperty("mysqlName"));

			// ==然后 开始 写 昨天写的很多次 的重复的代码,获取连接
			Class.forName(properties.getProperty("mysqlName"));

			/**
			 * ==第一个方法，就只是 丢配置文件里面的东西进去而已， 至于 上面声明 到的 很多
			 * statement啊，ResultSet啊，都是用到 下面 的关闭方法 的变量
			 */
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));

			/**
			 * 第二种写法，常规获取 输入流 和配置文件路径 的方法
			 */
			/*
			 * File file=new File("JDBCUtil.propertites"); InputStream
			 * inputStream=new FileInputStream(file);
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}

		return connection;
	}

	// ==关闭 的方法，第一个 用的statement
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {

				statement.close();
			}
			if (connection != null) {

				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (preparedStatement != null) {

				preparedStatement.close();
			}
			if (connection != null) {

				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
