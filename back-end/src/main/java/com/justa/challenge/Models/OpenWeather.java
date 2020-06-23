package com.justa.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class OpenWeather {

    private Coordinates coord;
    private List<Weather> weather;
    private MainStats main;
    private String name;

    @Override
    public String toString() {
        return "City: " + name + '\n' +
                coord.toString() + '\n' +
                main.toString() + '\n' +
                weather.get(0).toString();
    }
}
