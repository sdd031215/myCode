package com.ledu.pattern;

import java.util.Comparator;

public class TestStrategy {

	public TestStrategy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Integer a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
				62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

//		Sorter sorter = new Sorter(new BubbleSorter());
//		sorter.sort(a);
		Sorter sorter = new Sorter(new BubbleSorter());
		sorter.sort(a,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1 - o2;
			}
		});

		for (Integer s : a)
			System.out.print(s + " ");
	}
}
