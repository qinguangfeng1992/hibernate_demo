package com.qinguangfeng.entity810;
/**
 * 该线程 用于 输出 结果 

 * @author Administrator
 *
 */
public class ShuChuThread extends Thread{
	public ShuChuThread(String name){
		super(name);
		
	}
	
	public void run(){
		while(true){
	
		
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
