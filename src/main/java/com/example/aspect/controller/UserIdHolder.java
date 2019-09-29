package com.example.aspect.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserIdHolder {

    private ThreadLocal<Long> localUserId = new ThreadLocal<>();

    public AutoCloseable withUser(Long userId) {
        if(localUserId.get() != null) {
            throw new UnsupportedOperationException();
        }
        localUserId.set(userId);
        return () -> {
            log.info("remove user from local context");
            localUserId.remove();
        };
    }

    public Long getUserId() {
        return localUserId.get();
    }
}
