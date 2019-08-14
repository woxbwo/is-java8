package com.is.service.java8.lambda;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: LambdaTest2
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 14:57
 */
public class LambdaTest2 {
    //数组转list
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zbbiex1",44,4444.99),
            new Employee(2,"zbbiex2",83,5555.99),
            new Employee(3,"zbbiex3",27,3333.99),
            new Employee(4,"zbbiex4",24,7777.99),
            new Employee(5,"zbbiex5",36,8888.99),
            new Employee(6,"zbbiex6",45,6666.99)

    );
    @Test
    public void test3(){
        MyFilterFunction<Long,Long,Long> filterFunction = (x,y)->x*y;
        System.out.println(filterFunction.handler(100L,100L));
    }
    @Test
    public void test2(){
        MyFunction<String,String> myFunction = (x)->x.toUpperCase();
        String str = myFunction.getValue("zbbieX");
        System.out.println(str);

    }
    @Test
    public void test1(){
        Collections.sort(this.employees,(e1, e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(),e2.getAge());
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
