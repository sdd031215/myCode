package com.ledu.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Copy_4_of_Main {

//	public static int returnHigh(int[] ci){
//		
//		return 0;
//	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		String counts = sc.nextLine();
		int count = Integer.parseInt(counts);
		
		if(count < 0) System.exit(-1);
		int[] a = new int[count];
		
		while(count > 0){
			String version = sc.nextLine();
			
			a[count-1] = Integer.parseInt(version);
			
			count--;
		}
		
		String countsb = sc.nextLine();
		int countb = Integer.parseInt(countsb);
		if(countb < 0) System.exit(-1);
		
		int[] b = new int[countb];
		while(countb > 0){
			String version = sc.nextLine();
			
			b[countb-1] = Integer.parseInt(version);
			
			countb--;
		}
		
		String countsc = sc.nextLine();
		int countc = Integer.parseInt(countsc);
		if(countc < 0) System.exit(-1);
		
		int[] c = new int[countc];
		while(countc > 0){
			String version = sc.nextLine();
			
			c[countc-1] = Integer.parseInt(version);
			
			countc--;
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		int i = 0;
		int j = 0;
		int k = 0;
		String sout = "";
		while(i<a.length && j<b.length && k<c.length){
			if(a[i] == b[j] && a[i] == c[k]){
				sout += a[i]+" ";
				
				i++;
				j++;
				k++;
			}
			
			if(i<a.length && j<b.length && k<c.length && a[i] < b[j]){
				i++;
			}
			if(i<a.length && j<b.length && k<c.length && b[j] < c[k]){
				j++;
			}
			if(i<a.length && j<b.length && k<c.length && a[i] > c[k]){
				k++;
			}
		}
		
		if(sout.length()==0)
			System.out.println("");
		else
			System.out.println(sout.substring(0,sout.length()-1));
		
	}



}
