package com.qinguangfeng.entity810;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程 之  服务器端的 编写
 * 这是 给 别人发个我 这个服务器  所写的
 * @author Administrator
 *
 */
public class ServerDuan {

	public static void main(String[] args) {
		
		try {
		/**
		 * 这种点来点去，接收来接收去的 情况 最好赶紧消化掉。
		 */
			while(true){
				
				ServerSocket serverSocket = new ServerSocket(7777);
			
			System.out.println("服务器启动了。。");
	     	Socket s=	serverSocket.accept();//===需要拿个Socket 来接，才能点出下面的getInputStream（）方法
	     	System.out.println("有个东东要来。");
			
			InputStream inputStream=s.getInputStream();

			byte[] data=new byte[1024];
			//==学杰哥 的写法，但是却忘记丢 数组进去了
			int length=inputStream.read(data);
			
			while(length!=-1){
                       for(int i=0;i<length;i++){
				    	 System.out.print(data[i]);
				     }
				     length=inputStream.read(data);
			}
			inputStream.close();
			 s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//port端口的意思
		

	}

}
