package com.qinguangfeng.entity811;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端，用来 接收 客户端 发送 的消息 还有 用来 回复 客户端，相关的OK和ERROR消息
 * 
 * @author Administrator
 *
 */
public class ServerDuan {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(9999);
		
		 System.out.println("服务器启动了。。");
		 Socket socket =null;
		 while (true) {
		 socket = serverSocket.accept();
			 System.out.println("消息来了。");
           /**
            * 要创建 一个 新建 的线程类对象，再把 socket丢进去，才能和线程类发生关系！！！
            */
			 SerThread t=new SerThread(socket);
              t.start();
		}
		

	}
}
