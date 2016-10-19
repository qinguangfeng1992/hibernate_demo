package com.qinguangfeng.entity820;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 这个是 测试 阿里巴巴 的Druin 的连接池 的测试类
 * 
 * @author Administrator
 *
 */
public class TestDruin {

	public static void main(String[] args) {

		try {
//创建 连接池
			DruidDataSourceFactory dataSourceFactory = new DruidDataSourceFactory();
//创建 输入流 集合
			Properties properties = new Properties();
/**
 * ==获取配置文件,记住 是要用 本类  去获取 这个配置文件！！！！
 * 配置文件 的单词要写对，properties
 */
			InputStream inputStream = TestDruin.class.getResourceAsStream("druid.properties");
//加载 配置里的信息
			properties.load(inputStream);
/**
 * ==创建 数据源，导包 也要导 对！！！！！！！！！！javax.sql.DataSource;
 */
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//==获取连接		
			Connection connection = dataSource.getConnection();
			
			//System.out.println(connection.toString());
//== 添加一个 预编译，防止注入式 攻击	
		PreparedStatement preparedStatement=	connection.prepareStatement("Select * from grade");
			
//==	
		ResultSet resultSet = preparedStatement.executeQuery();

		// ==要先搬出 封装好的类,和集合List
		Grade_JavaBean bean = null;
		List<Grade_JavaBean> list = new ArrayList<Grade_JavaBean>();
		while (resultSet.next()) {

			bean = new Grade_JavaBean();

			// ==果然 这里面 写的 不是 1 或者2 ，而是 具体的列名
			bean.setGradeId(resultSet.getInt("gradeId"));
			bean.setGradeName(resultSet.getString("gradeName"));
			list.add(bean);

		}
		/**
		 * ==判断 这个执行查询的 集合不为空，且这个集合 的大小要有值，就是大于0 原来 如此 判断 的是 封装类 是否为空 已经
		 * 遍历循环 的是 这个封装类 的 新变量 对应 这个集合 输出也是 输出这个新变量
		 */
		if (bean != null && list.size() > 0) {

			// ==接着 遍历循环 输出这个 集合里面的值
			for (Grade_JavaBean beans : list) {
				System.out.println(beans.toString());
			}

		}
		JDBC_Util.close(connection, preparedStatement, resultSet);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
