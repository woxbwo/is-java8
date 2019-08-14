package com.is.service.java8.start;

import com.is.service.java8.model.Employee;

/**
 * @ClassName: FilterEmpBySalary
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 9:51
 */
public class FilterEmpBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000 ? true : false;
    }


}
