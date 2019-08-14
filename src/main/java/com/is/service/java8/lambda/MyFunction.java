package com.is.service.java8.lambda;

/**
 * @ClassName: MyFunction
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.14 14:52
 */
@FunctionalInterface
public interface MyFunction<R,T> {
    R getValue(T t);
}
