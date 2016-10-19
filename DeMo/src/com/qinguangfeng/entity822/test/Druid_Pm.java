package com.qinguangfeng.entity822.test;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.qinguangfeng.entity822.pm_bean.Pm_Category;
import com.qinguangfeng.entity822.pm_utils.Util;

public class Druid_Pm {

	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			InputStream inStream = Druid_Pm.class.getResourceAsStream("druid.properties");
			properties.load(inStream);

			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

			Connection connection = dataSource.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from pm_category");
			ResultSet resultSet = preparedStatement.executeQuery();

			Pm_Category category = null;
			List<Pm_Category> list = new ArrayList<Pm_Category>();

			while (resultSet.next()) {
				category = new Pm_Category();

				category.setID(resultSet.getString("ID"));
				category.setPM_CG_SYSUUID(resultSet.getString("PM_CG_SYSUUID"));
				category.setPM_NAME(resultSet.getString("PM_NAME"));
				category.setPM_MCH_ID(resultSet.getString("PM_MCH_ID"));
				category.setPM_PIC_BIG_URL(resultSet.getString("PM_PIC_BIG_URL"));
				category.setPM_PIC_SMALL_URL(resultSet.getString("PM_PIC_SMALL_URL"));
				category.setPM_FLAG(resultSet.getString("PM_FLAG"));
				category.setPM_CREATE_USER_ID(resultSet.getString("PM_CREATE_USER_ID"));
				category.setPM_CREATE_TIME(resultSet.getString("PM_CREATE_TIME"));
				category.setPM_UPDATE_USER_ID(resultSet.getString("PM_UPDATE_USER_ID"));
				category.setPM_UPDATE_TIME(resultSet.getString("PM_UPDATE_TIME"));
				category.setPM_DEL(resultSet.getString("PM_DEL"));

				list.add(category);

			}

			if (category != null && list.size() > 0) {

				for (Pm_Category categorys : list) {

					System.out.println(categorys);

				}

			}

			Util.close(connection, preparedStatement, resultSet);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
