package com.qinguangfeng.entity822.pm_utils;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Util {
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;

	/*public static void main(String[] args) {
		Util.getConnection();
	}
*/
	// ==获取连接的方法
	public static Connection getConnection() {

		try {
			Properties properties = new Properties();

			InputStream inputStream = Util.class.getResourceAsStream("pm.properties");

			properties.load(inputStream);

//			return DruidDataSourceFactory.createDataSource(properties).getConnection();
		
			Class.forName(properties.getProperty("className"));

			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));

			System.out.println(connection);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// ==第一种关闭的方法
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
			// TODO: handle exception
		}

	}

	// ==第二种关闭的方法

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
			// TODO: handle exception
		}

	}

}
