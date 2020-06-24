package com.justa.challenge.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ApiResponse {

    private String token;
    private Long id;
    private String username;
    private String email;
}
