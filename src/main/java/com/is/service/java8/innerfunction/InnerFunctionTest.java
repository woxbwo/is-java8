package com.is.service.java8.innerfunction;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName: InnerFunctionTest
 * @Description:
 * Java8 四大核心函数式接口
 * 1.Consumer<T> 消费型接口
 *      void accept(T t);
 * 2.Supplier<T> 供给型接口
 *      T get();
 * 3.Function<T,R> 函数型接口
 *      R apply(T t)
 * 4.Predicate<T t> 断言型接口
 *     boolean test(T t)
 *
 * @Author: Coding_wxb
 */

public class InnerFunctionTest {
    @Test
    public void test4(){
        List<Employee> employeeList = filterEmployee(this.employees, (emp) ->{
            return emp.getAge()>35?true:false;
        });
        employeeList.forEach(System.out::println);

    }

    List<Employee> filterEmployee(List<Employee> list, Predicate<Employee> predicate){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : list) {
            if(predicate.test(employee)){
                result.add(employee);
            }
        }
        return result;
    }

    @Test
    public void test3(){
        Function<List<Employee>,Employee> function = (emps) ->{
            for (Employee employee : emps) {
                if(employee.getId() ==3){
                    return employee;
                }
            }
            return null;
        };
        System.out.println(function.apply(this.employees).toString());
    }
    @Test
    public void test2(){
        Supplier<List<Long>> supplier = ()->{
            List res = new ArrayList();
            Random random = new Random(3);
            for (int i = 0; i < 100; i++) {
                res.add(random.nextLong());
            }
            return res;
        };
        List<Long> longs = supplier.get();
        for (Long o :longs) {
            System.out.println(o);
        }
    }
    @Test
    public void test1(){
        StringBuffer buffer = new StringBuffer("zb");
        Consumer<StringBuffer> consumer = (x)->{
            buffer.append("biextop");
        };
        consumer.accept(buffer);
        System.out.println(buffer);
    }
    //数组转list
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zbbiex1",83,4444.99),
            new Employee(2,"zbbiex2",83,5555.99),
            new Employee(3,"zbbiex3",27,3333.99),
            new Employee(4,"zbbiex4",24,7777.99),
            new Employee(5,"zbbiex5",36,8888.99),
            new Employee(6,"zbbiex6",45,6666.99)

    );


}
