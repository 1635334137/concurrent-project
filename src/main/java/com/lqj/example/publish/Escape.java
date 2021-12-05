package com.lqj.example.publish;

import com.lqj.annoations.NotRecommend;
import com.lqj.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 用来描述发布对象还未初始化完成，即被引用，造成引用逸出
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            //Escape在执行构造函数时，即被this所引用，造成对象实例化未完成就被使用了（采用工厂方法和私有构造方法解决）
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
