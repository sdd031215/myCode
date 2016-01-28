package com.ledu.thread;

public class ThreadTest implements Runnable {
public static int a = 0;

	public void run() {
		for (int k = 0; k < 5; k++) {
			a = a + 1;
			System.out.println(Thread.currentThread().getName() + a);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Runnable r = new ThreadTest();
		Thread t = new Thread(r);
		t.start();
		t.join();
		System.out.println(a);
	}
}