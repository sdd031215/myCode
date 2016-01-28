package com.ledu.pool.objectpool;

public abstract class BasePoolableObjectFactory implements  PoolableObjectFactory  
{  
	/** 
	* 生成新对象 
	*  
	* @param clsType 
	*            对象类型 
	* @return 新对象 
	*/  
	public Object createObject(Class clsType)  
	{  
	try  
	{  
	    return clsType.newInstance();  
	}  
	catch (InstantiationException e)  
	{  
	    e.printStackTrace();  
	}  
	catch (IllegalAccessException e)  
	{  
	    e.printStackTrace();  
	}  
	
	return null;  
	}  
	
	/** 
	* 对象在使用过程中内部状态会发生变化，当归还对象池时可能需要将对象还原为原始状态 
	*  
	* @return 还原后的对象（这里直接创建了一个新对象） 
	*/  
	public Object clearObject(Object obj)  
	{  
		obj = null;  
		return new Object();  
	}  
	
	/** 
	* 销毁一个对象 
	*  
	* @param obj 
	*            要销毁的对象 
	*/  
	public void destroyObject(Object obj)  
	{  
		obj = null;  
	}  
}  
