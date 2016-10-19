package com.qinguangfeng.entity811;

import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 这个是 服务器端，
 * 
 * @author Administrator
 *
 */
public class ServerUdp {

	public static void main(String[] args) {
		System.out.println("欢迎来到聊天室。。");
		System.out.println("====天使方====");
		//==封装到类里 的接收方
		SerLei lei = new SerLei();
		lei.start();
		Scanner s = new Scanner(System.in);

		try {
			//===发送方
			while (true) {
			//System.out.println("说：");
			String str = s.next();
			byte[] msg = str.getBytes();
			DatagramSocket socket2 = new DatagramSocket();
			InetAddress address = InetAddress.getByName("127.0.0.1");
			DatagramPacket packet2 = new DatagramPacket(msg, msg.length, address, 5678);
			socket2.send(packet2);

			socket2.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
