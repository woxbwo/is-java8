package com.is.service.java8.streamapi;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: StreamAPITest4
 * @Description:
 * 终止操作
 * 查找与匹配
 * 1.allMath 检查是否匹配所有元素
 * 2.anyMath 检查至少匹配一个元素
 * 3.noneMath 检查是否没有匹配元素
 * 4.findFirst 返回第一个元素
 * 5.count 返回流元素的总个数
 * 6.max 返回流中的最大值
 * 6.min 返回流中的最小值
 *
 *
 * 归约：
 * reduce        -->可以将流中的元素反复结合，得到一个值
 *
 *
 * 收集：
 * collect 将流转换为其他形式，接受一个Collector的实现，用于给流中的元素汇总方法
 *
 * 分区：
 *
 *
 * @Author: Coding_wxb
 */

public class StreamAPITest4 {
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zbbiex1",83,4444.99, Employee.Status.FREE),
            new Employee(2,"zbbiex2",83,5555.99, Employee.Status.BUSY),
            new Employee(3,"zbbiex3",27,3333.99, Employee.Status.VOCATION),
            new Employee(4,"zbbiex4",24,7777.99, Employee.Status.VOCATION),
            new Employee(5,"zbbiex6",36,8888.99, Employee.Status.BUSY),
            new Employee(6,"zbbiex6",45,6666.99, Employee.Status.FREE)
    );
    @Test
    public void test9(){
        DoubleSummaryStatistics collect = this.employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getAverage());

        String str = this.employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(str);
    }
    /**
     *@description:
     * 分区
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test8(){
        Map<Boolean, List<Employee>> collect = this.employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect);
    }
    /**
     *@description:
     *  收集
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test7(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = this.employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (((Employee) e).getAge() < 35) {
                        return "青年";
                    } else if (((Employee) e).getAge() < 50 && ((Employee) e).getAge() > 35) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));

        collect.forEach((k,v)->{
            System.out.print(k+":");
            System.out.println(v);
        });
    }
    /**
     *@description:
     *@params:  分组
     *@return:  void
     **/
    @Test
    public void test6(){
        Map<Employee.Status, List<Employee>> collect = this.employees.stream()
                .collect(Collectors.groupingBy((e) -> e.getStatus()));
        collect.forEach((k,v)->{
            System.out.print(k+":");
            System.out.println(v);
        });
    }
    @Test
    public void test5(){
        //总数
        Long count = this.employees.stream()
                .collect(Collectors.counting());
        //平均住
        Double av = this.employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        //总和
        Double sum = this.employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        //最大值
        Optional<Employee> max = this.employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        //最小值
        Optional<Double> min = this.employees.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);
    }
    /**
     *@description:
     *
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test4(){
        this.employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("----------------------------");
        this.employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("---------------------------");
        HashSet<String> collect = this.employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collect.forEach(System.out::println);

    }
    /**
     *@description:
     * 归约
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("-------------------------:"+sum);
        Optional<Double> reduce = this.employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test2(){
        long count = this.employees.stream()
                .count();
        System.out.println(count);
        Optional<Employee> max = this.employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        Optional<Double> min = this.employees.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);
        System.out.println(min.get());
    }
    @Test
    public void test1(){
        boolean b1 = this.employees.stream()
                .allMatch((emp) -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
        boolean b2 = this.employees.stream()
                .anyMatch((emp) -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
        boolean b3 = this.employees.stream()
                .noneMatch((emp) -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);
        Optional<Employee> first = this.employees.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());
        Optional<Employee> any = this.employees.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());
    }

}
