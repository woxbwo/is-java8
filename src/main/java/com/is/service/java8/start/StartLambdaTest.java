package com.is.service.java8.start;

import com.is.service.java8.model.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: StartLambdaTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.13 19:09
 */
public class StartLambdaTest {
    /**
     *@description:
     * 匿名内部类
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(12);
        treeSet.add(89);
        for (Integer integer : treeSet) {
            System.out.printf(integer+"");
        }
    }

    /**
     *@description:
     * Lambda 表达式
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test2(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
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

    /**
     *@description:
     *@params: 查询员工年龄大于35的
     *@return:  void
     **/
    @Test
    public void test3(){
        List<Employee> employees = filterEmpByAge(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    List<Employee> filterEmpByAge(List<Employee> emps){
        List<Employee> res = new ArrayList<>();
        for (Employee employee : emps) {
            if(employee.getAge()>35){
                res.add(employee);
            }
        }
        return res;
    }

    /**
     *@description:
     * 查询工资大于5000的员工
     *@params:  []
     *@return:  void
     **/
    @Test
    public void test4(){
        List<Employee> res = filterEmpBySalary(this.employees);
        for (Employee employee : res) {
            System.out.println(employee);
        }
    }
    List<Employee> filterEmpBySalary(List<Employee> emps){
        List<Employee> res = new ArrayList<>();
        for (Employee employee : emps) {
            if(employee.getSalary()>5000){
                res.add(employee);
            }
        }
        return res;
    }



}
