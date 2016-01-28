package com.ledu.pool.objectpool;

/** 
 * 池化对象管理工厂接口PoolableObjectFactory：用于管理对象池中对象的创建、还原、销毁 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public interface PoolableObjectFactory  
{  
    /** 
     * 生成新对象 
     *  
     * @param clsType 
     *            对象类型 
     * @return 新对象 
     */  
    public Object createObject(Class clsType);  
  
    /** 
     * 对象在使用过程中内部状态会发生变化，当归还对象池时可能需要将对象还原为原始状态 
     *  
     * @return 将对象还原为原始状态 
     */  
    public Object clearObject(Object obj);  
  
    /** 
     * 销毁一个对象 
     *  
     * @param obj 
     *            要销毁的对象 
     */  
    public void destroyObject(Object obj);  
} 