package com.ledu.test;

import java.util.ArrayList;
import java.util.List;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
public class A {    
//	public static void main(String[] args)   throws Exception {        
//		try {            
//			try {                throw new Sneeze();            }             
//				catch ( Annoyance a ) {                
//				System.out.println("Caught Annoyance");                
//				throw a;            
//				}
//		} 
//		catch ( Sneeze s ) {            
//			System.out.println("Caught Sneeze");            
//			return ;        
//			}        
//		finally {            System.out.println("Hello World!");        
//		}    }
	
	public static void main(String[] args) {
		List<String> list  = new ArrayList<String>();
		while(true){
			list.add("内存溢出啦！！！");
		}
	}
	}