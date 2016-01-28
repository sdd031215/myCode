package com.ledu.sort;

public class InsertSort {  
	
	public static void main(String[] args) {
		insertSort();
		
	}
	
	public static void insertSort_self(){  
	    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
	    
	    
	} 
	
	//4 5 12 13 15 17 18 23 25 27 34 34 35 38 49 49 51 53 54 56 62 64 65 76 78 97 98 99
	public static void insertSort(){  
	    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	    int temp=0;  
	    for(int i=1;i<a.length;i++){  
	       int j=i-1;  
	       temp=a[i];  
	       for(;j>=0 && temp<a[j];j--){  
	           a[j+1]=a[j];  //将大于temp的值整体后移一个单位  
	       }  
	       a[j+1]=temp;  
	    }  
	   
	    for(int i=0;i<a.length;i++){  
	       System.out.print(a[i] + " ");  
	    }  
	}
}
