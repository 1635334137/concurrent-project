package com.lqj.example.singleton;

import com.lqj.annoations.NotRecommend;
import com.lqj.annoations.NotThreadSafe;
import com.lqj.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例在第一次使用时初始化
 */
@ThreadSafe
@NotRecommend
public class SingletonExample1 {

    //私有构造方法
    private SingletonExample1(){

    }

    //单例对象
    private volatile static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){//双重检测机制(指令重排，线程不安全。解决：使用volatile修饰单例)
            synchronized (SingletonExample1.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }
}
