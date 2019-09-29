package com.example.aspect.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SomeService {

    private final UserIdHolder holder;

    @LocalUserId
    public Long test(GetUserDTO userId) {
        log.info("service.enter {}", userId);
        Long result = holder.getUserId();
        log.info("service.exit {}", result);
        return result;
    }
}
