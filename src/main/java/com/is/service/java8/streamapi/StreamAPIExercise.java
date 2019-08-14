package com.is.service.java8.streamapi;
import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName: StreamAPIExercise
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 16:10
 */
public class StreamAPIExercise {
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zbbiex1",83,4444.99, Employee.Status.FREE),
            new Employee(2,"zbbiex2",83,5555.99, Employee.Status.BUSY),
            new Employee(3,"zbbiex3",27,3333.99, Employee.Status.VOCATION),
            new Employee(4,"zbbiex4",24,7777.99, Employee.Status.VOCATION),
            new Employee(5,"zbbiex6",36,8888.99, Employee.Status.BUSY),
            new Employee(6,"zbbiex6",45,6666.99, Employee.Status.FREE)
    );
    /**
     *
     * 1.给定一个数字列表，返回一个有每个数字平方组成的列表
     *
     * 2.怎么用map和reduce统计流中有多少个员工
     *
     * 3.
     *
     **/

    @Test
    public void test2(){
        Optional<Integer> reduce = this.employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }



    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        List<Integer> numsList = Arrays.stream(nums)
                .map((x) -> x * x)
                .collect(Collectors.toList());
        numsList.forEach(System.out::println);
    }

}
