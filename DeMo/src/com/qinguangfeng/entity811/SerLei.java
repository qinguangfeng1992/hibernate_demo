package com.qinguangfeng.entity811;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 这个用来 封装 接收方的，即 ServerUdp
 * 
 * @author Administrator
 *
 */
public class SerLei extends Thread {
	public void run() {

		try {

			while (true) {
				//System.out.print("我：");
				//System.out.println("");
				byte[] data = new byte[1024];
				DatagramSocket socket = new DatagramSocket(5678);

				DatagramPacket packet = new DatagramPacket(data, data.length);

				socket.receive(packet);

				byte[] msg = packet.getData();
				String str = new String(msg);
				System.out.println("说:" + str);
				socket.close();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
