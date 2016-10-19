package com.qinguangfeng.entity810;

/**
 * 线程三 计算 201 到300 的累加和
 * 
 * @author Administrator * 第一个思路，比较low，是属于 浪费型的新建了三个 类来继承线程
 */
public class ThreeLeiJia extends Thread {
	private static int sumThree;

	public static int getSumThree() {

		return sumThree;
	}

	public static void setSumThree(int sumThree) {
		ThreeLeiJia.sumThree = sumThree;

	}

	public void run() {

		for (int i = 201; i <= 300; i++) {
			sumThree += i;

		}
		System.out.println(Thread.currentThread().getName() + ":" + sumThree);

	}
}
