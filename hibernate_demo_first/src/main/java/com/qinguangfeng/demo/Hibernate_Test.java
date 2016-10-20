package com.qinguangfeng.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.qinguangfeng.entity.User;

public class Hibernate_Test {

	/**
	 * 这六步要记住
	 */
	@Test
	public void testFirst() {
		// 1
		Configuration configuration = new Configuration();
		// 2// 默认到src根目录下找到 hibernate.cfg.xml这个配置文件
		configuration.configure();
		// 3// 创建一个会话工厂
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 4// 有了会话工厂之后，就打开一个会话
		Session session = sessionFactory.openSession();
		// 5// 有了会话之后，就开始传输,开始事务的处理
		Transaction transaction = session.beginTransaction();
		/* transaction.begin(); */
		// 6// 事务开始之后，就用会话存一个实体进去
		session.save(new User("qin", "aa"));
		// 7// 存了实体进去之后，就要用事务 进行提交
		transaction.commit();
		// 8// 完毕之后再关闭这个会话
		session.close();
		// 9// 创建会话 的会话工厂也要关闭
		sessionFactory.close();

	}

}
