package com.lqj.example.singleton;

import com.lqj.annoations.NotThreadSafe;
import com.lqj.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时加载
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造方法
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
