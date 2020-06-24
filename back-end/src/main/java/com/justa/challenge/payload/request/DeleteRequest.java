package com.justa.challenge.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
public class DeleteRequest {

    @NotBlank
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
