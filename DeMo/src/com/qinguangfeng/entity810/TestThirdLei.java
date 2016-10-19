package com.qinguangfeng.entity810;
/**
 * 第三种  求1-300的究极方法
 */
public class TestThirdLei {

	public static void main(String[] args) {
		Thread t1=new ThirdLeiJia(0,100);
		Thread t2=new ThirdLeiJia(101,200);
		Thread t3=new ThirdLeiJia(201,300);
	
	
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ThirdLeiJia.sum);
		

	}

}
