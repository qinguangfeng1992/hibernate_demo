package com.qinguangfeng.entity810;

/**
 * 做1-300累加和 的第二种思路： 只需要一个类 写方法，然后在Main方法测试 时，再新建三个线程 这 用的还是 集成线程的方法
 * 
 * @author Administrator extends Thread
 */
public class LeiJia implements Runnable {
	/**
	 * 这个 方法 就需要 用到构造方法 传参数了
	 * 
	 */
	private int one;
	private int two;

	public int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		
	}

	public LeiJia(int one, int two) {

		this.one = one;
		this.two = two;

	}

	@Override
	public void run() {
		// ===上面 声明了变量，自然下面的方法 也可以
		int sum = 0;
		for (int i = one; i <= two; i++) {

			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + ":" + sum);
		total=sum;//===而且这个 求和的 变量 还得 放在 类的for循环里面，才能不被覆盖
	}

}
