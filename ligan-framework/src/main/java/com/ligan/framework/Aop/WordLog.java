package com.ligan.framework.Aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: ligan
 * @description: word操作Aop日志
 * @author: fenglg
 * @create: 2021-08-11 18:04
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WordLog {
    String value() default "wordLog";

}
