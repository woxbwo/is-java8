package com.is.service.java8.lambda;
@FunctionalInterface
public interface MyFilterFunction<R,T,K> {
    R handler(T t, K k);
}
