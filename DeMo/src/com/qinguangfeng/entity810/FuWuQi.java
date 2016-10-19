package com.qinguangfeng.entity810;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这才是自己玩的 服务器
 * 
 * @author Administrator
 *
 */
public class FuWuQi {

	public static void main(String[] args) {
		try {
			while(true){
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("服务器启动");
			Socket s = serverSocket.accept();
			
			InputStream inputStream = s.getInputStream();
		//	byte[] data = new byte[1024]; 根本用不着数组，哎，现在什么时候用数组 我都不知道。。
			char contr =(char) inputStream.read();
			switch (contr) {
			case 'A':
				System.out.println("正在执行查询任务。。");
				break;

			case 'B':
				System.out.println("正在执行删除任务。。");
				break;

			case 'C':
				System.out.println("正在执行修改任务。。");
				break;

			case 'D':
				System.out.println("正在执行增加任务。。");
				break;

			}
			inputStream.close();
            s.close();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
