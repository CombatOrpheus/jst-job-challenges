package com.justa.challenge.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
