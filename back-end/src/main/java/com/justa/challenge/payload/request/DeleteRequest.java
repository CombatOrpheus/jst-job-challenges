package com.justa.challenge.payload.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteRequest {

    @NotBlank
    private String token;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
