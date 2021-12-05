package com.lqj.example.singleton;

import com.lqj.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时加载
 */
@ThreadSafe
public class SingletonExample3 {

    //私有构造方法
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //注意顺序，都是静态修饰，会依次从上往下执行
    static {
        instance = new SingletonExample3();
    }

    //静态工厂方法
    public static SingletonExample3 getInstance(){
        return instance;
    }
}
