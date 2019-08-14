package com.is.service.java8.streamapi;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPITest2
 * @Description:
 * 中间操作
 * 1.filter 接受Lambda 从六流中排除元素
 * 2.limit 截断流，使元素不超过指定的元素
 * 3.skip(n) 跳过元素返回一个扔掉前n个元素的流，若流中的元素不足，则返回一个空流
 * 4.distinct 筛选 通过流产生的hashCode（）和equal（）去除重复元素
 * 5.映射
 * （1）map 接受一个Lambda表达式，将元素转换为其它形式提取元素，接受一个函数作为参数，就该函数将会被应用到每个元素上，并将其银蛇为一个新的元素
 *  (2)flatMap 接受一个函数作为参数，将流中的每一个值都换成另外一个流，然后将所有的流都连城一个流
 * @Author: Coding_wxb
 */

public class StreamAPITest2 {
    //数组转list
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zbbiex1",83,4444.99),
            new Employee(2,"zbbiex2",83,5555.99),
            new Employee(3,"zbbiex3",27,3333.99),
            new Employee(4,"zbbiex4",24,7777.99),
            new Employee(5,"zbbiex5",36,8888.99),
            new Employee(6,"zbbiex6",45,6666.99)

    );
    @Test
    public void test3(){
        List<String> strList = Arrays.asList("aa","bb","cc");
        Stream<Stream<Character>> streamStream = strList.stream()
                .map(StreamAPITest2::filterCharacter);

        Stream<Character> characterStream = strList.stream()
                .flatMap(StreamAPITest2::filterCharacter);
        characterStream.forEach(System.out::println);


    }

    static Stream<Character> filterCharacter(String str){
        List strList = new ArrayList();
        for (char c : str.toCharArray()) {
            strList.add(c);
        }
        return  strList.stream();
    }
    @Test
    public void test2(){
        List<String> strList = Arrays.asList("aa","bb","cc");
        strList.stream()
                .map((x)->x.toUpperCase())
                .forEach(System.out::println);
        this.employees.stream()
                .map(Employee::getAge)
                .forEach(System.out::println);
    }
    @Test
    public void test1(){
        employees.stream()
                .filter((e)->{
                    return e.getAge()>30;
                })
                .limit(4)
                //.skip(1)
                .distinct()
                .forEach(System.out::println);
    }

}
