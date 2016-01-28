package com.ledu.pool.objectpool;

/** 
 * String类型管理工厂类StringPoolableObjectFactory：提供对String类型对象的管理 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public class StringPoolableObjectFactory extends BasePoolableObjectFactory  
{  
    /** 单例 */  
    private static StringPoolableObjectFactory instance = null;  
  
    /** 
     * 单例模式 
     *  
     * @return 基础池化对象管理工厂的单例 
     */  
    public static StringPoolableObjectFactory getInstance()  
    {  
        if (null == instance)  
        {  
            instance = new StringPoolableObjectFactory();  
        }  
  
        return instance;  
    }  
  
    /** 
     * 对象在使用过程中内部状态会发生变化，当归还对象池时可能需要将对象还原为原始状态 
     *  
     * @return 新对象 
     */  
    public Object clearObject(Object obj)  
    {  
        obj = null;  
        return new String();  
    }  
}  
