package com.ledu.sort;

public class shellSort {

	public static void main(String[] args) {
		int[] intsort = {21,5,2,3,7,94,3,2,5,23,65,22,66,23};
		//insertSort(intsort);
		shellSort(intsort, new int[]{1,3,6}, 1);
		for(int i:intsort){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * 希尔排序
	 * @param a	需排序的数组
	 * @param d	增量
	 * @param numOfD	循环多少次
	 */
	public static void shellSort(int[] a, int[] d, int numOfD){
		int i,j,k,m,span;
		int temp;
		int n = a.length;
		
		for(m = 0; m < numOfD; m++){
			
			span = d[m];
			for(k = 0; k < span; k++){
				
				for(i = k; i < n-span; i = i+ span){
					
					temp = a[i + span];
					j = i;
					while(j > -1 && temp <= a[j]){
						a[j + span] = a[j];
						j = j - span;
					}
					
					a[j + span] = temp;
				}
			}
		}
	}
	
	/**
	 * 插入排序 
	 * 稳定排序
	 * @param a
	 */
	public static void insertSort(int[] a){
		int i,j,temp;
		int n = a.length;
		
		for(i=0; i<n-1; i++){
			temp = a[i+1];
			j = i;
			while(j > -1 && temp < a[j]){//< or <= ??    稳定排序
				a[j + 1] = a[j];
				j--;
			}
			
			a[j+1] = temp;
		}
	}
	
	
}
