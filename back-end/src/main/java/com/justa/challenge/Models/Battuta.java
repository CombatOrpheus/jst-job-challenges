package com.justa.challenge.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @AllArgsConstructor @ToString
public class Battuta {

    private String name;
    private String code;
    private String region;
    private String city;
}
