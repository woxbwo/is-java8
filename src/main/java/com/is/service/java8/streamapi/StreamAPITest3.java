package com.is.service.java8.streamapi;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StreamAPITest3
 * @Description:
 * 排序 sorted()
 * 自然排序
 * Comparable
 * 定制排序
 * Comparator
 * @Author: Coding_wxb
 */

public class StreamAPITest3 {
    //数组转list
    List<Employee> employees = Arrays.asList(
            new Employee(1, "zbbiex1", 83, 4444.99),
            new Employee(2, "zbbiex2", 83, 5555.99),
            new Employee(3, "zbbiex3", 27, 3333.99),
            new Employee(4, "zbbiex4", 24, 7777.99),
            new Employee(5, "zbbiex5", 36, 8888.99),
            new Employee(6, "zbbiex6", 45, 6666.99)

    );

    @Test
    public void test() {
        List<String> strList = Arrays.asList("aa", "bb", "cc");
        strList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------");
        this.employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return -Integer.compare(e1.getAge(), e2.getAge());
                })
                .forEach(System.out::println);
    }
}