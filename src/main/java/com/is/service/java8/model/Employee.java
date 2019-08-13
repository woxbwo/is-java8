package com.is.service.java8.model;

import lombok.*;

/**
 * @ClassName: Employee
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.13 19:08
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NonNull
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private Status status;


    public Employee(Integer id ,String name){
        this.id = id;
        this.name = name;
    }
    public Employee(Integer id ,String name,Integer age,Double salary){
        this.id = id;
        this.name = name;
        this.age = age ;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    public enum Status {
        FREE,BUSY,VOCATION;
    }

    public static void main(String[] args) {
        Employee e = new Employee(1);
        Employee emp = new Employee(1,"zbbiex",89,8999.99);
    }

}
