package com.qinguangfeng.entity810;

/**
 * 线程二 计算 101 到200 的累加和
 * 
 * @author Administrator * 第一个思路，比较low，是属于 浪费型的新建了三个 类来继承线程
 */
public class TwoLeiJia extends Thread {
	private static int sumTwo;

	public static int getSumTwo() {
		return sumTwo;
	}

	public static void setSumTwo(int sumTwo) {
		TwoLeiJia.sumTwo = sumTwo;
	}

	public void run() {

		for (int i = 101; i <= 200; i++) {
			sumTwo += i;

		}
		System.out.println(Thread.currentThread().getName() + ":" + sumTwo);

	}

}
