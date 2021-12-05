package com.lqj.example.syncContainer;

import com.lqj.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 当我们使用foreach或者迭代器来遍历我们的集合时，尽量不要在集合遍历时删除的相关更新操作
 * 如果一定要做删除操作，要在遍历时给删除元素做标记，遍历结束后再进行删除操作
 * 在单线程情况下异常，多线程情况下更加容易出现异常
 */
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1){ //foreach
        for (Integer i: v1) {
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){ //迭代器
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //success
    private static void test3(Vector<Integer> v1){ //for
        for (int i = 0; i < v1.size(); i++) {
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        test2(v1);
    }










}
