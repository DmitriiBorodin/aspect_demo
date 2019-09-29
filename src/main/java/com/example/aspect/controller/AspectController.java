package com.example.aspect.controller;

import com.example.aspect.dto.GetUserDTO;
import com.example.aspect.service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AspectController {

    private final SomeService service;

    @PostMapping("/")
    public Long test(@RequestBody GetUserDTO dto) {
        return service.test(dto);
    }
}
