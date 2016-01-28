package com.ledu.test;

public class TestCall {

	public TestCall() {
		// TODO Auto-generated constructor stub
	}

	public static Supplier testClosure(){
	    final int i = 1;
	    return new Supplier() {
	        @Override
	        public Integer get() {
	            return i;
	        }
	    };
	   
	}
	
	public static void main(String[] args) {
//		System.out.println(TestCall.testClosure().get());
//		
//		 try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		 for(int i =0;i<1000000;i++){
//			 i=new Integer(1) + i;
//			 int a = 1987 * 123;
//		 }
		 
		byte[] a1,a2,a3,a4;
		int _1MB = 1024*1024;
		a1 = new byte[2* _1MB ];
		a2 = new byte[2* _1MB ];
		a3 = new byte[2* _1MB ];
		a4 = new byte[4* _1MB ];
		
		 
	}
}
