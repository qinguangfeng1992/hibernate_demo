package com.qinguangfeng.entity810;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 该线程 用于 从一个文件夹 复制到 另一个文件夹 
 * 
 * 用的是 重写 run()方法， 还有 字节流 的，输出，
 * 
 * @author Administrator
 *
 */
public class CopyThread extends Thread {
	/**
	 * D:/IO/dir/shiping.ASF 记得关闭 字节输出流
	 */

	
	private double byt;
	public static double fenshu;
	
	public void run() {

		try {
			// =先读到的目标文件夹
			File f = new File("D:/IO/dir/shiping.ASF");
			File f2 = new File("D:/IO/shiping.ASF");

			InputStream inputStream = new FileInputStream(f);
			OutputStream outputStream = new FileOutputStream(f2);

			int length = 0;
			/**我就说肯定有新的方法 涉及读取文件的  字节
			 * 返回此输入流下一个方法调用可以
			 * 
			 * 不受阻塞地从此输入流读取（或跳过）的
			 * 估计的总字节数。
			 */
			int sum=inputStream.available();
			
			byte[] data = new byte[1024];
			while ((length = inputStream.read(data)) != -1) {
				/**
				 * 这里 是重点 和 难点
				 */
				byt=byt+length;//====用一个变量接收，读到的每一行的字节
				fenshu=byt/sum*100;//====再把这每一行字节  除以一个 估算好的大概的总字节数，就可以得到百分比
				
				outputStream.write(data, 0, length);

			}
			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
