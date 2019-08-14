package com.is.service.java8.streamapi;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPITest1
 * 三部：
 *
 * 1.创建流
 *
 * 2.中间操作
 *
 * 3.终止操作
 *
 * @Description:
 * @Author: Coding_wxb
 */

public class StreamAPITest1 {
    /**
     *@description:
     * 创建流的几种方式
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test1(){
        //1.可以通过 Collection 集合中的stream()-串行流 或者 parallelStream()-并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //2.通过Arrays中的静态方法stream()获取流
        Employee[]  employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);
        //3.通过Stream类中的静态方法of()获取流
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        //4.创建无限流
        //迭代
        Stream.iterate(1, (x) -> x + 2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("=======================================");
        //生成
        Stream.generate(()->(int)(Math.random()+1))
                .limit(10)
                .forEach(System.out::println);

    }

}
