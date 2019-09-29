package com.example.aspect.dto;

import lombok.Data;

@Data
public class GetUserDTO implements UserIdAware {

    private Long userId;
}
