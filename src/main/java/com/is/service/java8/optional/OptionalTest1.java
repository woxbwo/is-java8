package com.is.service.java8.optional;
import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName: OptionalTest1
 * 主要是避免java中的空指针异常
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 16:12
 */
public class OptionalTest1 {
    @Test
    public void test1(){
        //of()创建一个optional实例
        Optional<Employee> optionalEmployee = Optional.of(new Employee());
        //get()获取容器中的值
        Employee employee = optionalEmployee.get();
        System.out.println(employee);


    }

    @Test
    public void test2(){
        //empty() 构建一个空的optional实例
        Optional<Employee> empty = Optional.empty();
        System.out.println(empty.get());

    }

    @Test
    public void test3(){
        //ofNullable() 构建一个空的optional或者不为空的实例
        Optional<Employee> op1 = Optional.ofNullable(new Employee());
        //System.out.println(op1.get());
        Optional<Employee> op2 = Optional.ofNullable(null);
        //System.out.println(op2.get()); //发生空指针异常

        //isPresent() 判断optional是否包含值
        if(op1.isPresent()){
            System.out.println(op1.get());
        }else {
            System.out.println("optional 中没有值");
        }

        //orElse(T t) 如果optional中包含值。则返回值，否则返回t
        Employee employee = op1.orElse(new Employee());


        //orElseGet(supplier s) 如果optional中包含值，则返回值，否则返回 s 提供的值
        Employee employee1 = op1.orElseGet(() -> {
            return new Employee();
        });
    }

    @Test
    public void test4(){
        //map(Function<R T，> f) 如果有值对值进行处理，返回处理后的optional ,否则返回Optional.empty()
        Optional<Employee> op = Optional
                .ofNullable(new Employee(1, "zbbiex1", 83, 4444.99, Employee.Status.FREE));
        Optional<String> s = op.map((e) -> e.getName());
        System.out.println(s.get());
        //flatMap(function mapper) 与map类似，要求返回值必须是optional
        Optional<String> s1 = op.flatMap((e) -> Optional.ofNullable(e.getName()));
        System.out.println(s1.get());
    }

}
