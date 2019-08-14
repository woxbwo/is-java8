package com.is.service.java8.forkjoin;

import lombok.NoArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName: ForkJoinCalCulate
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 15:22
 */
@NoArgsConstructor
public class ForkJoinCalCulate extends RecursiveTask<Long> {
    /**
     * 利用fork/join 框架实现数的累加
     * JDK1.7使用
     **/
    private long start;
    private long end;
    private static final long THRESHOLDS = 10000;

    public  ForkJoinCalCulate(long start,long end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THRESHOLDS){
            long sum = 0;
            for (long i = start; i <=end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start+end)/2;
            ForkJoinCalCulate left = new ForkJoinCalCulate(start,middle);
            left.fork(); //拆分子任务，同时压入到线程队列
            ForkJoinCalCulate right = new ForkJoinCalCulate(middle+1,end);
            right.fork(); //拆分
            //合并
            return left.join()+right.join();
        }
    }
}
