package com.qinguangfeng.entity810;

/**
 * 测试 1到300的累加和
 * 
 * @author Administrator
 *
 */
public class TotalSum {

	public static void main(String[] args) throws Exception {
		// ====线程一，main方法计算 三个 线程累加和 的总和
		int total = 0;

		OneLeiJia t1 = new OneLeiJia();
		t1.start();

		TwoLeiJia t2 = new TwoLeiJia();
		t2.start();

		ThreeLeiJia t3 = new ThreeLeiJia();
		t3.start();
/**
 * 谁调用，谁阻塞，现在这种情况是main方法调用
 * 所以，
 */
		t1.join();//==调用1，那main方法的 输出 肯定就在 t1后
		t2.join();//==调用2，那main方法的 输出 肯定就在 t2后
		t3.join();//==调用3，那main方法的 输出 肯定就在 t3后
		//==全部都调用，那就肯定在三个方法 都计算出来后，Main方法再输出 它们的和

		total = t1.getSumOne() + t2.getSumTwo() + t3.getSumThree();

		System.out.println(total);

		/*
		 * ShuChu s=new ShuChu();
		 * 
		 * Thread t1=new Thread(s,"第一个"); t1.start();
		 * 
		 * Thread t2=new Thread(s,"第二个"); t2.start();
		 * 
		 * Thread t3=new Thread(s,"第三个"); t3.start();
		 */

	}

}
