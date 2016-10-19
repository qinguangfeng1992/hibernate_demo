package com.qinguangfeng.entity810;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 自己玩的 客户端
 * @author Administrator
 *
 */
public class KeHuDuan {

	public static void main(String[] args) {
		
		
		try {
			Socket socket=new Socket("127.0.0.1", 9999);
			System.out.println("数据正在发送。。");
			OutputStream outputStream=socket.getOutputStream();
		//	char[] data=new char[1024];//真的不用数组，不用怀疑。。。
			outputStream.write('B');
			
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
