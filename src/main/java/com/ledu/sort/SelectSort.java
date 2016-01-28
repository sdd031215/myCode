package com.ledu.sort;

/**
 * 直接选择排序
 * @author sdd
 *
 */
public class SelectSort {

	public static void selectSort(int[] a){
		int i,j,small;
		int temp;
		int n = a.length;
		
		for( i = 0; i < n-1; i++ ){
			small = i;					//设第i个数据元素最小
			for(j = i+1; j < n; j++){	//寻找最小的数据元素
				if(a[j] < a[small])
					small = j;			//记住最小元素的下标
			}
			
			if(small != j){
				temp = a[i];
				a[i] = a[small];
				a[small] = temp;
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = {2,3,6,8,9,4,1};
		selectSort(a);
		
		for(int i:a){
			System.out.println(i);
		}
	}

}
