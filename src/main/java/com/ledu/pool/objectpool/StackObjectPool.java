package com.ledu.pool.objectpool;

import java.util.NoSuchElementException;
import java.util.Stack;

/** 
 * 栈式对象池类StackObjectPool：提供栈式对象池的操作实现 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-16 
 *  
 */  
public class StackObjectPool extends BaseObjectPool implements ObjectPool  
{  
    /** 栈式对象池 */  
    protected Stack<Object> pool = null;  
  
    /** 池化对象管理工厂 */  
    protected PoolableObjectFactory factory = null;  
  
    /** 对象池中所存放对象的类型 */  
    private Class clsType = Object.class;  
  
    /** 对象池中所能申请的对象数目上限 */  
    protected int maxNum = 100;  
  
    /** 已借出对象数目 */  
    protected int activeNum = 0;  
  
    /** 
     * 构造函数，构建栈式对象池 
     *  
     * @param factory 
     *            池化对象管理工厂 
     * @param maxIdle 
     *            对象池中空闲对象数目上限 
     * @param initIdleCapacity 
     *            对象池初始化容量 
     */  
    public StackObjectPool(PoolableObjectFactory factory, int maxNum,  
            Class clsType)  
    {  
        this.factory = factory;  
        this.activeNum = 0;  
        this.maxNum = maxNum;  
        this.clsType = clsType;  
        this.pool = new Stack<Object>();  
    }  
  
    /** 
     * 从对象池中取出对象 
     *  
     * @return 取出的对象 
     */  
    public Object borrowObject()  
    {  
        synchronized (pool)  
        {  
            // 断言对象池是否处于开放状态  
            assertOpen();  
  
            Object currentObj = null;  
  
            // 当前对象池有对象可用  
            if (!pool.empty())  
            {  
                // 直接从对象池中取出对象  
                currentObj = pool.pop();  
            }  
            // 当前对象池无可用对象  
            else  
            {  
                // 已借出对象数目小于对象池所要求对象数目最大值  
                if (activeNum < maxNum)  
                {  
                    // 池化对象管理工厂为空，则无法生成新对象，抛出异常  
                    if (null == factory)  
                    {  
                        throw new NoSuchElementException();  
                    }  
  
                    // 由池化对象管理工厂生成新对象  
                    currentObj = factory.createObject(clsType);  
  
                    // 生成对象为空则抛出异常  
                    if (null == currentObj)  
                    {  
                        throw new NoSuchElementException(  
                                "StackObjectPool.borrowObject()返回NULL.");  
                    }  
                }  
                // 已借出对象数目到达对象池所要求对象数目最大值  
                else  
                {  
                    // 等待其它对象返回对象到池中  
                    try  
                    {  
                        pool.wait();  
                    }  
                    catch (InterruptedException e)  
                    {  
                        e.printStackTrace();  
                    }  
  
                    // 从池中取出对象  
                    currentObj = pool.pop();  
                }  
            }  
  
            // 增加已借出对象数目  
            ++activeNum;  
  
            return currentObj;  
        }  
    }  
  
    /** 
     * 将对象返回给对象池 
     *  
     * @param obj 
     *            需要返回的对象 
     */  
    public void returnObject(Object obj)  
    {  
        synchronized (pool)  
        {  
            // 断言对象池是否处于开放状态  
            assertOpen();  
  
            // 确保对象具有正确的类型  
            if (obj.getClass() == clsType)  
            {  
                pool.push(obj);  
  
                // 减少已借出对象数目  
                --activeNum;  
  
                // numActive发生改变，通知其他阻塞线程  
                pool.notifyAll();  
            }  
            else  
            {  
                throw new IllegalArgumentException("类型"  
                        + obj.getClass().getName() + "要求类型" + clsType.getName()  
                        + "不匹配！");  
            }  
        }  
    }  
  
    /** 
     * 清除对象池中所有空闲对象 
     */  
    public synchronized void clear()  
    {  
        pool.clear();  
    }  
  
    /** 
     * 关闭对象池，并释放所占资源 
     */  
    public synchronized void close()  
    {  
        super.close();  
        clear();  
  
        pool = null;  
        factory = null;  
        clsType = Object.class;  
        maxNum = -1;  
        activeNum = -1;  
    }  
  
    /** 
     * 返回对象池中已经借出的对象数目 
     *  
     * @return 活跃对象数目 
     */  
    public synchronized int getActiveNum()  
    {  
        return activeNum;  
    }  
  
    /** 
     * 返回当前对象池中可用的空闲对象数目 
     *  
     * @return 空闲对象数目 
     */  
    public synchronized int getMaxNum()  
    {  
        return maxNum;  
    }  
  
    /** 
     * 返回对象池中空闲的对象数目 
     *  
     * @return 空闲对象数目 
     */  
    public synchronized int getIdleNum()  
    {  
        return pool.size();  
    }  
  
    /** 
     * 设置池化对象管理工厂用于管理对象池中的对象 
     *  
     * @param factory 
     *            池化对象管理工厂 
     */  
    public synchronized void setFactory(PoolableObjectFactory factory)  
    {  
        this.factory = factory;  
    }  
  
    public synchronized Stack<Object> getPool()  
    {  
        return pool;  
    }  
  
    public synchronized void setPool(Stack<Object> pool)  
    {  
        this.pool = pool;  
    }  
  
    public synchronized Class getClsType()  
    {  
        return clsType;  
    }  
  
    public synchronized void setClsType(Class clsType)  
    {  
        this.clsType = clsType;  
    }  
  
    public synchronized void setMaxNum(int maxNum)  
    {  
        this.maxNum = maxNum;  
    }  
  
    public synchronized void setActiveNum(int activeNum)  
    {  
        this.activeNum = activeNum;  
    }  
  
    public synchronized PoolableObjectFactory getFactory()  
    {  
        return factory;  
    }  
} 