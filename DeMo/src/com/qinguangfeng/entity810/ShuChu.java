package com.qinguangfeng.entity810;

public class ShuChu implements Runnable {

	
	@Override
	public void run() {
		
		int sum=0;
		for(int i=0;i<=100;i++){
			sum+=i;
			
		}
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
	
	public void zonghe(){
		
		
	}

}
