package com.example.pr14.aop;
import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.pr14.Services.*.*(..))")
    public void servicesMethods(){}

}
