package com.qinguangfeng.entity819;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;

/**
 *  测试 数据库 加上Scanner 输入 让 用户输出 所要查询的 字段的资料
 *  
 *  并且 再加上 为了 防止 sql 注入式 攻击 的漏洞，
 *  而使用 ==预编译 PrepareStatement
 * @author Administrator
 *
 */
public class JDBC_Prepare {
private static String url="jdbc:mysql://127.0.0.1:3306/studb";
private static String username="root";
private static String psd="hzit";
//private static Statement statement;

private static PreparedStatement preparedStatement;
	public static void main(String[] args) {
	
try {
	
		Scanner s=new Scanner(System.in);
		System.out.println("请输入课程编号:");
		String subjectno=s.nextLine();
		System.out.println("请输入课程名称");
		String subjectname=s.nextLine();
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =DriverManager.getConnection(url,username,psd);
		

		
		//String str="Select SubjectNo,SubjectName from subject where SubjectNo='"+subjectno+"'AND SubjectName='"+subjectname+"'";
		String str="Select SubjectNo,SubjectName from subject where SubjectNo=?"+"AND SubjectName=?";
		/**
		 * 以下 是三句 预编译代码
		 */
		
		preparedStatement=connection.prepareStatement(str);
		
		preparedStatement.setString(1, subjectno);
		preparedStatement.setString(2, subjectname);
		
		ResultSet result =preparedStatement.executeQuery();
	/*	if(result.next()){*/
			while(result.next()){
				
				
				System.out.println("subject:"+result.getInt("SubjectNo")+"\tSubjectName:"+result.getString("SubjectName"));
			
			}
			
		/*}else{
			System.out.println("没有数据");
		}*/
			/**
			 * 用 预编译，以下两句就多余了，不用写了
			 * 还不行哦，！没有 以下这句，还会空指针异常啊，
			 * 因为我在一开始 声明了 私有化了 statement,并且没有用到它，
			 * 也没有给他赋值，所以其实，用预编译，就没必要 用 statement了
			 * 即 这三句可以省略
			 *  //==private static Statement statement;
			 * //==//statement=connection.createStatement();
			  //statement.close();
			 */
			//statement=connection.createStatement();
		//ResultSet resultSet=statement.executeQuery(str);
		
	
		
		result.close();
		//statement.close();
		connection.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

}
