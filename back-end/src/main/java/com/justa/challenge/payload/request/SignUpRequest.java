package com.justa.challenge.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank
    private String email;
    //TODO email validation trough api.cloudmersive.com/validate/email/address/full

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
