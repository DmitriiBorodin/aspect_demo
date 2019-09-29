package com.example.aspect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class MyAspect {

    private final UserIdHolder userIdHolder;

    @Around("@annotation(com.example.aspect.controller.LocalUserId)")
    public Object surround(ProceedingJoinPoint joinPoint) throws Throwable {
        Long id = getIdFromArgs(joinPoint);
        log.info("store local user");
        try(AutoCloseable closeable = userIdHolder.withUser(id)) {
            return joinPoint.proceed();
        }
    }

    private Long getIdFromArgs(ProceedingJoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                    .filter(arg -> arg instanceof UserIdAware)
                    .findAny()
                    .map(UserIdAware.class::cast)
                    .map(UserIdAware::getUserId)
                    .orElse(null);
    }
}
