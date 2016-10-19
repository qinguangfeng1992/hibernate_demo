package com.qinguangfeng.entity811;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务器线程类，用来 把在 main方法里的 服务器接收 和获取 的方法全部转移到这里 
 * 关键点 ，就在于 把服务器那里 的 一个对象 传到 这个线程类里，然
 * 保证，while循环 每一次 循环都能创建一个 线程 并且 完成 服务器接收和获取的功能。实现多线程
 * @author Administrator
 *
 */
public class SerThread extends Thread{
	private Socket socket;
	public SerThread(Socket socket){
		
		this.socket= socket;
		
	}
	
	public void run() {
		
		InputStream inputStream;
		try {
			inputStream = socket.getInputStream();
			// ==开启输入流
			/**
			 * 创建 对象输入流，把输入流写进对象输入流 再用对象输入流 ，点出，输入的对象， 再判断
			 */
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Message m = (Message) objectInputStream.readObject();

			String msg = null;
			/**
			 * 最好用 字符串.出 对象.出getName(),是对象流 自带 的获得 创建m对象 里面的名字，
			 */
			if ("hzit".equals(m.getUuid()) && "123".equals(m.getPassword())) {

				msg = "OK";

			} else {
				msg = "Error";
			}

			/**
			 * 一定要写 服务器 输入流打住,否则输入不出去
			 */
			socket.shutdownInput();

			// ==开启输出流

			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(msg.getBytes());

			outputStream.close();

			objectInputStream.close();
			inputStream.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
