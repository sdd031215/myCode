package com.ledu.BitSet;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		int count = 10000;
		BitSet bit = new BitSet(count);
		int i = 1000;
		while(i > 0) {		
			bit.set((int)(Math.random()*count));
			i--;
		}
		
		int ii = 0;
		for(int index=0; index<count; index++) {
			if(bit.get(index)) {
				System.out.println(index+",");
				ii++;
			}
		}
		System.out.println("end"+ii);			
	}
}