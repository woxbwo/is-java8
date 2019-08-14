package com.is.service.java8.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @ClassName: TestForkJoin
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 15:28
 */
public class TestForkJoin {
    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalCulate(0,100000000000L);
        Long invoke = pool.invoke(task);
        System.out.println(invoke);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }
    /**
     *@description:
     * java8中实现
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test2(){
        Instant start = Instant.now();
        //串行流
        OptionalLong reduce = LongStream.rangeClosed(0, 100000000000L)
                .parallel()  //切换成并行流
                .reduce(Long::sum);
        System.out.println(reduce.getAsLong());
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

}
