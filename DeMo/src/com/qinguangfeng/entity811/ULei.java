package com.qinguangfeng.entity811;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 这个是 用来 封装 发送方的类的，即UserUdp
 * 
 * @author Administrator
 *
 */
public class ULei extends Thread {

	public void run() {
		Scanner s = new Scanner(System.in);
		try {

			while (true) {
				//System.out.print("请输入消息：");
				//System.out.println("");
				String str = s.next();
				// ===这是发的 报文，所以不用 写，端口是接收的人才要写的，
				DatagramSocket socket = new DatagramSocket();
				// ===这是发的 报文，，要发送给谁，所以要写那个人的端口 和IP
				InetAddress address = InetAddress.getByName("127.0.0.1");
				
				//===
				DatagramPacket packet = new DatagramPacket(str.getBytes(),str.length(), address, 9999);

				socket.send(packet);
		
				socket.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
