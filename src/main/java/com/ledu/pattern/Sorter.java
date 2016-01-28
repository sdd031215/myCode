package com.ledu.pattern;

import java.util.Comparator;

public class Sorter  {

	private SorterStrategy sort;
	
	public Sorter(SorterStrategy sort) {
		this.sort = sort;
		
	}
	
	public <T extends Comparable<T>> void sort(T[] t){
		sort.sort((T[]) t);
	}
	
	public <T> void sort(T[] list, Comparator<T> comp){
		sort.sort(list, comp);
	}

}
