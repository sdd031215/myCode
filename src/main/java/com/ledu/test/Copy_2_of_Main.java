package com.ledu.test;


import java.util.Scanner;

public class Copy_2_of_Main {

	public static int returnHigh(int[] ci){
		int sum = 0;
		for(int i:ci){
			sum += i;
		}
		
		double d = 996*1.0 / 340;
		
		
		return (int) Math.rint(sum * d);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		String counts = sc.nextLine();
		String[] cs = counts.split(" ");
		int[] ci = new int[4];
		int i = 0;
		
		for(String c : cs){
			ci[i++] = Integer.parseInt(c);
			
		}
		
		System.out.println(returnHigh(ci));
		
	}



}
