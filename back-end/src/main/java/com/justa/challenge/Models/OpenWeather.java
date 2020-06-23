package com.justa.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @Getter @Setter @ToString
public class OpenWeather {

    private Coordinates coord;
    private Weather weather;
    private MainStats main;
    private String name;
}
