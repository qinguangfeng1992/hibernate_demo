package com.qinguangfeng.entity811;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端 要 实现 输出流 发送一个 信息 对象 给 服务器
 * 还要写一个 输入流 方法 接收 服务器 反馈回来的 信息
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("请输入用户名：");
		String name=s.next();
		
		System.out.print("请输入密码：");
		String password=s.next();
		
		try {
			Socket socket=new Socket("127.0.0.1", 9999);
			
			OutputStream outputStream=socket.getOutputStream();//==开启输出流
			/**
			 * ===创建一个对象，
			 * 创建一个对象输出流，把输出流写入对象输出流
			 * 再用对象输出流，输出 新建的对象
			 */
			Message msg=new Message(name, password);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(msg);
			
			socket.shutdownOutput();//==关闭 输出流
			
			
			InputStream inputStream=socket.getInputStream();//==开启输入流
			//InputStreamReader(1,2)，1 代表要丢一个 输入流的对象，2代表 制定的字符编码
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String str=bufferedReader.readLine();
			System.out.println(socket.getInetAddress()+"地址说的消息是："+str);
			
			/**
			 *输入流关掉，
			 *缓冲流关掉
			 *对象流关掉
			 *输出流关掉
			 *套接字关掉
			 *服务器关掉
			 */
			inputStream.close();
			bufferedReader.close();
			inputStreamReader.close();
			objectOutputStream.close();
			outputStream.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
