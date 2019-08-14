package com.is.service.java8.start;

import com.is.service.java8.model.Employee;

/**
 * @ClassName: FilterEmpByAge
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 9:50
 */
public class FilterEmpByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee o) {
        return o.getAge()>35?true:false;
    }

}
