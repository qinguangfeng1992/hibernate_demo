package com.qinguangfeng.entity810;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


/**
 * 客户端的
 * 原来输入一次 的话 ，就不需要 循环！只要输入一次就好了，那一次就把所有的 单个拼音字符 拼成 串了
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws Exception, Exception {
		Socket s = new Socket("192.168.0.174", 8989);
		OutputStream outputStream = s.getOutputStream();
		//byte[] data = new byte[]{'q','i','n','g','u','a','n','g','f','e','n','g',};
	    

		//byte []data=new byte[1024];
	/*	data[0]=1;
		data[1]=11;
		data[2]=122;
		data[1022]=127;
	*/
		byte[] data ="俺是覃光峰".getBytes(); 
		//byte[] btInput = stringData.getBytes();
	
	
		outputStream.write(data);
		System.out.println("数据正在发送。。");
		//===以下  是接收服务器 回消息的输入流 代码
        s.shutdownOutput();
        
        InputStream inputStream=s.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        String str=bufferedReader.readLine();
        System.out.println("服务器的回话。。"+str);
        bufferedReader.close();
        inputStream.close();
        outputStream.close();
	}

}
