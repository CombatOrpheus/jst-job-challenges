package com.justa.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class User {

    //TODO Integrate database
    private Long id;
    private String username;
    private String name;
    private String password;
}
