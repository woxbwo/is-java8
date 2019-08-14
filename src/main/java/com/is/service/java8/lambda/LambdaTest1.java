package com.is.service.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName: LambdaTest1
 * @Description:
 * Lambda 表达式
 * 两部分：
 * 左侧   Lambda表达式的参数列表
 * 右侧   Lambda所要执行的功能
 *
 * 语法格式一：
 * 无参，无返回值
 *      （）->....
 *
 * 语法格式二：
 * 一个参数，无返回值
 *      （x）->....
 *
 * 语法格式三：
 * 多条语句
 *      （x）->{
 *
 *      }
 *
 * 语法格式四
 * 如果只有一行语句返回的return可以省略
 *
 * 总结：
 * 上联：左侧遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * @Author: Coding_wxb
 *
 */

public class LambdaTest1 {
    /**
     *@description:
     * 多条语句
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y)->{
            System.out.println(x);
            return Integer.compare(x,y);
        };

    }
    /**
     *@description:
     * 一个参数，无返回值
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test2(){
        Consumer<String> consumer = (x)-> System.out.println(x);
        consumer.accept("zbbiex");
    }
    /**
     *@description:
     * 无参，无返回值
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.printf("-------------");
            }
        };
        r.run();

        Runnable runnable = () -> System.out.println("--- running ----");
        runnable.run();
    }


}
