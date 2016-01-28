package com.ledu.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Test {

	public static void main(String[] args) {
		Derived d = new Derived();
        System.out.println( d.whenAmISet );
	
        System.out.println(getNum());
       
	}
	
	private static float getNum(){
		float f = 0;
		try{
        	 f = 1/0;
        }catch(Exception e){
        	System.out.println("异常了");
        	return f;
        }finally{
        	System.out.println("最后处理");
        }
		
		return f;
	}
}

  class Base
{
    Base() {
        preProcess();
    }
 
    void preProcess() {System.out.println("base construct!");}
}
  
  
  class Derived extends Base
{
    public String whenAmISet = "set when declared";
 
    @Override void preProcess()
    {
        whenAmISet = "set in preProcess()";
    }
}