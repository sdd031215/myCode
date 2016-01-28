package com.ledu.test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

//	public static int returnHigh(int[] ci){
//		
//		return 0;
//	}
	
	public static void main(String[] args) {
		
		String ss = "abcdefghijkl";
		Scanner sc = new Scanner(System.in); 
		String count = sc.nextLine();
		int counts = Integer.parseInt(count);
		String[] strs = new String[10000];
		int k = 0;
		for(int i = 0;i< counts;i++){
			strs[i] = sc.nextLine();
			k ++;
		}
		
		for(int j=0;j< k; j++){
			System.out.println(returnAt(strs[j]));
		}
			

	}

private static int returnAt(String str) {
	String ss = "abcdefghijkl";
	char[] cs = str.toCharArray();
	int i = 0;
	//cs[i]
	return 1;
} 



}
