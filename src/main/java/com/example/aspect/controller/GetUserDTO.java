package com.example.aspect.controller;

import lombok.Data;

@Data
public class GetUserDTO implements UserIdAware{

    private Long userId;
}
