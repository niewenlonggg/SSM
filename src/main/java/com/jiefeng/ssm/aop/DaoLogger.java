package com.jiefeng.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class DaoLogger {

    Logger logger = LoggerFactory.getLogger(DaoLogger.class);

    @Before("execution(public * com.jiefeng.ssm.dao.*.*(*))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.info(methodName + " 方法被调用, 调用参数为: " + args);
    }

}
