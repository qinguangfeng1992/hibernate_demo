package com.qinguangfeng.entity810;

/**
 * 线程一计算 0 到100 的累加和,。
 * 
 * 第一个思路，比较low，是属于 浪费型的新建了三个 类来继承线程
 * 
 * @author Administrator
 *
 */
public class OneLeiJia extends Thread {
	private static int sumThree;

	public static int getSumOne() {
		return sumThree;
	}

	public static void setSumOne(int sumOne) {
		OneLeiJia.sumThree = sumOne;
	}

	public void run() {

		for (int i = 0; i <= 100; i++) {
			sumThree += i;

		}
		System.out.println(Thread.currentThread().getName() + ":" + sumThree);

	}

}
