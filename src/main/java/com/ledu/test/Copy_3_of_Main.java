package com.ledu.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Copy_3_of_Main {

	public static int returnHigh(int[] ci){
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		String counts = sc.nextLine();
		int count = Integer.parseInt(counts);
		
		List<String[]> list = new ArrayList<String[]>();
		while(count > 0){
			String version = sc.nextLine();
			String[] str = version.split("\\.");
			list.add(str);
			
			count--;
		}
		
			int majorMax = 0;
			int minorMax = 0;
			int modiMax  = 0;
			String maxVersion = "";
			
			Iterator<String[]> it2 = list.iterator();
			while(it2.hasNext()){
				String[] str2 = it2.next();
				if(majorMax <= Integer.parseInt(str2[0]) && minorMax <= Integer.parseInt(str2[1]) &&  Integer.parseInt(str2[1]) % 2 == 0 ){
					
					if(str2.length==3 && modiMax < Integer.parseInt(str2[2])){
						modiMax =  Integer.parseInt(str2[2]);
						
						majorMax = Integer.parseInt(str2[0]);
						minorMax = Integer.parseInt(str2[1]);
						
						String strtemp = "";
						for(int j=0;j<str2.length;j++)
							strtemp += str2[j]+".";
						
						maxVersion = strtemp.substring(0, strtemp.length()-1);
					}else{
						majorMax = Integer.parseInt(str2[0]);
						minorMax = Integer.parseInt(str2[1]);
						
						String strtemp = "";
						for(int j=0;j<str2.length;j++)
							strtemp += str2[j]+".";
						
						maxVersion = strtemp.substring(0, strtemp.length()-1);
					}
					
					
				}
				
				
			}
			if(majorMax == 0){
				System.out.println("no stable available");
			}else{
				System.out.println(maxVersion);
			}
		
	}



}
