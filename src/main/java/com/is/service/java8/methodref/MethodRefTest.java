package com.is.service.java8.methodref;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.*;

/**
 * @ClassName: MethodRefTest
 * @Description:
 * Lambda的执行中的内容已经被实现了，可以使用方法引用
 * 方法引用
 * 主要的三种语法格式
 *
 * 对象::实例方法名称
 *
 * 类::静态方法名称
 *
 * 类::实例方法名称
 *
 * --》构造器应用
 * 创建对象
 * ClassName::new
 *
 * -->数组引用
 *
 *
 *
 * @Author: Coding_wxb
 */

public class MethodRefTest {
    @Test
    public void test6(){
        Function<Integer,String[]> function = (x) -> new String[x];
        Function<Integer,String[]> fun = String[]::new;
        System.out.println(fun.apply(20).length);
    }

    /**
     *@description:
     * 构造器应用
     * ClassName::new
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test5(){
        BiFunction<Integer,String,Employee> biFunction = Employee::new;
        System.out.println(biFunction.apply(3,"zbbiex"));
    }
    @Test
    public void test4(){
        Supplier<Employee> supplier = ()->new Employee();
        Employee employee = supplier.get();
        Supplier<Employee> supper = Employee::new;
    }
    /**
     *@description:
     * 类::实例方法名称
     * Lambda中的参数列表中，第一个参数是实例方法的调用者，第二个参数是实例方法的参数是，可以使用这种方式
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test3(){
        BiPredicate<String,String> predicate = (x, y)->x.equals(y);
        BiPredicate<String,String> biPredicate = String::equals;
    }
    /**
     *@description:
     * 类::静态方法名称
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test2(){
        Function<String,Integer> function = (str)->{
            return MethodRefTest.countStrLength(str);
        } ;
        Integer len = function.apply("qwer");
        System.out.println(len);

        Function<String,Integer> fun = MethodRefTest::countStrLength;
        System.out.println(fun.apply("wqwdwef  sdksdlv"));
    }
    /**
     *@description:
     * 对象::实例方法名称
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)->ps.println(x);
        con.accept("qwer");
        Consumer<String> consumer = ps::println;
        consumer.accept("abcd");
    }





    static int countStrLength(String str){
        return str.length();
    }

}
