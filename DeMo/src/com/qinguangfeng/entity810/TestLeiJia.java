package com.qinguangfeng.entity810;
/*
 * 测试 第二次 1-300累加和 的思路所用
 */
public class TestLeiJia {

	public static void main(String[] args) {
		/**
		 * 我这里 用的 实现 Runnable 接口的方法，所以Leijia类是一个实现类
		 * 没有继承线程，因为不能直接.点出Start（）开启线程的方法
		 * 只能是调用 累加类 里面的Run（）方法而已
		 * 
		 * 所以这个其实 和我 第一种求和 的思路一样，用的是get和set方法，
		 * 只不过 用来个 构造方法 来传参，让用户输入  稍微灵活一点而已而已
		 */
		
		LeiJia jia1=new LeiJia(0, 100);
		jia1.run();
		
		LeiJia jia2=new LeiJia(101, 200);
		jia2.run();
		
		LeiJia jia3=new LeiJia(201, 300);
		jia3.run();
		//===而且这个 求和的 变量 还得 放在 类的for循环里面，即total=sum;
       int  total=jia1.getTotal()+jia2.getTotal()+jia3.getTotal();
      
    		   System.out.println(total);
	}

}
