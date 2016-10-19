package com.qinguangfeng.entity820;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 测试 C3p0 的连接池 情况。。
 * 
 * @author Administrator
 *
 */
public class TestC3p0 {

	public static void main(String[] args) {

		try {
			// ==获取数据源 对象
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

			// ==获取连接
			Connection connection = comboPooledDataSource.getConnection();

			// System.out.println(connection);

			PreparedStatement preparedStatement = connection.prepareStatement("Select * from grade");

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

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
