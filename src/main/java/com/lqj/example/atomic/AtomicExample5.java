package com.lqj.example.atomic;


import com.lqj.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //AtomicIntegerFieldUpdater,原子性的更新某个类的某个实例的字段
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;//字段必须用volatile修饰

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();

        if(updater.compareAndSet(example5,100,120)){//如果字段等于100，则改为120
            log.info("update success 1,{}",example5.getCount());
        }
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success 2,{}",example5.getCount());
        }else {
            log.info("update failed,{}",example5.getCount());
        }
    }
}
