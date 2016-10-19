package com.qinguangfeng.entity811;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 这是 UDP 协议 的网络编程，需要的是在这个主方法里，做一个线程发送， 另外在新建一个类 接收 ，放到main方法里 做 另外一个线程 现在
 * ，我先做发送， z这个 是客户端
 * 
 * @author Administrator
 *
 */
public class UserUdp {

	public static void main(String[] args) {
		//==封装到类里 的发送方
		System.out.println("欢迎来到聊天室。。");
		//System.out.println("====恶魔方====");
		Scanner s = new Scanner(System.in);
		ULei lei = new ULei();
		lei.start();

		try {
				//===接收方
			while (true) {
				byte[] data = new byte[1024];
				DatagramSocket socket2 = new DatagramSocket(9999);

				DatagramPacket packet2 = new DatagramPacket(data, data.length);

				socket2.receive(packet2);

				byte[] msg = packet2.getData();
			
				String str = new String(msg);
				
				System.out.println("天使:" +str);
				socket2.close();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
