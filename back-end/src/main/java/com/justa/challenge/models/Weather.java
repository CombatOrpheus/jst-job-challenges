package com.justa.challenge.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Weather {

    private int id;
    private String description;

    @Override
    public String toString() {
        return description;
    }
}
