package com.ledu.pool.objectpool;

/** 
 * 基础对象池抽象类BaseObjectPool：提供最基本的对象池操作实现 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public abstract class BaseObjectPool implements ObjectPool  
{  
    /** 对象池是否已经关闭 */  
    private volatile boolean closed = false;  
  
    /** 
     * 返回对象池中空闲对象数目 
     *  
     * @return -1 
     */  
    public int getMaxNum()  
    {  
        return -1;  
    }  
  
    /** 
     * 返回对象池中已借出对象数目 
     *  
     * @return -1 
     */  
    public int getActiveNum()  
    {  
        return -1;  
    }  
  
    /** 
     * 清除对象池中所有空闲对象 
     */  
    public void clear()  
    {  
  
    }  
  
    /** 
     * 关闭对象池，设置状态为关闭 
     */  
    public void close()  
    {  
        closed = true;  
    }  
  
    /** 
     * 设置池化对象管理工厂用于管理对象池中的对象 
     *  
     * @param factory 
     *            池化对象管理工厂 
     */  
    public void setFactory(PoolableObjectFactory factory)  
    {  
  
    }  
  
    /** 
     * 返回对象池是否关闭 
     *  
     * @return 对象池关闭状态 
     */  
    protected final boolean isClosed()  
    {  
        return closed;  
    }  
  
    /** 
     * 断言对象池是否处于开放状态 
     *  
     * @throws IllegalStateException 
     */  
    protected final void assertOpen()  
    {  
        if (isClosed())  
        {  
            throw new IllegalStateException("【对象池处于关闭状态！无法进行相应操作！】");  
        }  
    }  
}