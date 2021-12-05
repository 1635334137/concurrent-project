package com.lqj.example.singleton;

import com.lqj.annoations.Recommend;
import com.lqj.annoations.ThreadSafe;

/**
 * 枚举模式:最安全
 *
 */
@ThreadSafe
@Recommend
public class SingletonExample4 {

    //私有构造方法
    private SingletonExample4(){

    }

    public static SingletonExample4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample4 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample4();
        }

        public SingletonExample4 getInstance(){
            return singleton;
        }
    }
}
