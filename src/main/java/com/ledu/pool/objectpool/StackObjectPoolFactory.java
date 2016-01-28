package com.ledu.pool.objectpool;

/** 
 * 栈式对象池工厂类StackObjectPoolFactory：提供生产栈式对象池的工厂 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public class StackObjectPoolFactory implements ObjectPoolFactory  
{  
    /** 单例 */  
    private static StackObjectPoolFactory instance = null;  
  
    /** 
     * 单例模式 
     *  
     * @return 栈式对象池工厂的单例 
     */  
    public static StackObjectPoolFactory getInstance()  
    {  
        if (null == instance)  
        {  
            instance = new StackObjectPoolFactory();  
        }  
  
        return instance;  
    }  
  
    /** 
     * 栈式对象池工厂，用于生成对象池 
     *  
     * @param factory 
     *            池化对象管理工厂 
     * @param maxIdle 
     *            对象池所申请的最大对象数目 
     * @param clsType 
     *            对象类型 
     * @return 
     */  
    public ObjectPool createPool(PoolableObjectFactory factory, int maxNum,  
            Class clsType)  
    {  
        return new StackObjectPool(factory, maxNum, clsType);  
    }  
}  
