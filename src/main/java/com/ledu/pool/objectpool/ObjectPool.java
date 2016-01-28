package com.ledu.pool.objectpool;

/** 
 * 对象池接口ObjectPool：管理对象池中对象的借出、归还等必要的操作 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public interface ObjectPool  
{  
    /** 
     * 从对象池中取出对象 
     *  
     * @return 取出的对象 
     */  
    public Object borrowObject();  
  
    /** 
     * 将对象返回给对象池 
     *  
     * @param obj 
     *            需要返回的对象 
     */  
    public void returnObject(Object obj);  
  
    /** 
     * 返回当前对象池所申请对象上限数目 
     *  
     * @return 对象上限数目 
     */  
    public int getMaxNum();  
  
    /** 
     * 返回对象池中已经借出的对象数目 
     *  
     * @return 活跃对象数目 
     */  
    public int getActiveNum();  
  
    /** 
     * 返回对象池中空闲的对象数目 
     *  
     * @return 空闲对象数目 
     */  
    public int getIdleNum();  
  
    /** 
     * 清除对象池中所有空闲对象 
     */  
    public void clear();  
  
    /** 
     * 关闭对象池，并释放所占资源 
     */  
    public void close();  
  
    /** 
     * 设置池化对象管理工厂用于管理对象池中的对象 
     *  
     * @param factory 
     *            池化对象管理工厂 
     */  
    public void setFactory(PoolableObjectFactory factory);  
} 