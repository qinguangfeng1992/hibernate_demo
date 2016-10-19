package com.qinguangfeng.entity810;
/**
 *第三种 求1-300累加和 的思路，即 使用构造方法传参数
 *还有  继承 Thread ，并且在Main方法里建立三个线程 并行来测试
 *
 * */
public class ThirdLeiJia extends Thread{
    private int one;
    private int two;
    public static int sum=0;
    
    public ThirdLeiJia(int one , int two){
    	this.one=one;
    	this.two=two;
    	
    	
    }
    
    public void run(){
    	
    	for(int i=one;i<=two;i++){
    		sum+=i;
    		
    	}
    	
    }
	
	
}
