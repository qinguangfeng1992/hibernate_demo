package com.qinguangfeng.entity810;

import java.text.DecimalFormat;

/**
 * 测试 从 文件复制程序 ，并显示  每500毫秒 输出一次  状态
 * @author Administrator
 *
 */
public class TestThread {

	public static void main(String[] args) {
		//====一个 复制的线程
		CopyThread c=new CopyThread();
		
		
		Thread t1=new Thread(c);
		t1.start();
	/**
	 * 前面  所学过 的用过 的  
	 * 保留 两位 小数 的  代码 方法
	 */
		DecimalFormat decimalFormat=new DecimalFormat("#00.00");
		/**
		 * CopyThread.fenshu<100 这段代码 和CopyThread.fenshu)这段代码
		 * 还有 这行代码 fenshu=byt/sum*100
		 */
		while(CopyThread.fenshu<100){
			try {
				Thread.sleep(500);
				System.out.println("当前复制了"+decimalFormat.format(CopyThread.fenshu)+"%");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}System.out.println("复制完毕！");
	
		
	
	

	}

}
