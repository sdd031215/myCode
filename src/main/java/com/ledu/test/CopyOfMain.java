package com.ledu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CopyOfMain {

	//用素数分解
	public List getSushu(int n){
		List sint = new ArrayList() ;
		int k = 0;
		for(int i=2; i<(int)Math.sqrt(n); i++){
			if(n%i == 0){
				sint.add(i);
				System.out.println(i);
			}
		}
		if(sint.size() == 0){
			sint.add(n);
		}
		return sint;
	}

	private void print(List ms) {
		String[][] s = new String[5][3*ms.size()]; 
		for(int n=0; n< 5; n++)
			for(int m=0;m<3*ms.size(); m++){
				s[n][m] = " ";
			}
		
		for(int i=0; i< ms.size(); i++){
			//ms[3*i]
			//System.out.println(i);
				if(ms.get(i).equals(1)){
					
					s[1][3*i + 1] = "|";
					s[2][3*i + 2] = "|";
				}else if (ms.get(i).equals(2)){
					s[0][3*i + 1] = "—";
					s[1][3*i + 2] = "|";
					s[2][3*i + 1] = "—";
					s[3][3*i + 0] = "|";
					s[4][3*i + 0] = "—";
				}else if (ms.get(i).equals(3)){
					s[0][3*i + 1] = "—";
					s[1][3*i + 2] = "|";
					s[2][3*i + 1] = "—";
					s[3][3*i + 2] = "|";
					s[4][3*i + 0] = "—";
				}else if (ms.get(i).equals(5)){
					s[0][3*i + 1] = "—";
					s[1][3*i + 0] = "|";
					s[2][3*i + 1] = "—";
					s[3][3*i + 2] = "|";
					s[4][3*i + 1] = "—";
				}else if (ms.get(i).equals(7)){
					s[0][3*i + 1] = "—";
					s[1][3*i + 2] = "|";
					s[3][3*i + 0] = "|";
				}
		}
		
		for(int n=0; n< 5; n++)
			for(int m=0;m<3*ms.size(); m++){
				System.out.println(s[n][m]);
			}
		
	}
	
	
	public static void main(String[] args) {
		
		CopyOfMain m = new CopyOfMain();
		List<Integer> ln = new ArrayList<Integer>();
		int k=0;
		while(true){
			
			Scanner sc = new Scanner(System.in); 
			String counts = sc.nextLine();
			if(counts == null || counts.length() == 0)
				break ;
			
			int c = Integer.parseInt(counts);
			ln.add(c);
			
		}
		
		for(int j=0;j<ln.size();j++){
			
			List ms = m.getSushu(ln.get(j));
			
			m.print(ms);
		}


	}



}
