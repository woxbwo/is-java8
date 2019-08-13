package com.is.service.java8.start;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName: StartLambdaTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.13 19:09
 */
public class StartLambdaTest {
    /**
     *@description:
     * 匿名内部类
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(12);
        treeSet.add(89);
        for (Integer integer : treeSet) {
            System.out.printf(integer+"");
        }
    }
}
