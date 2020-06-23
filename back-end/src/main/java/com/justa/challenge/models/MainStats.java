package com.justa.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class MainStats {

    private float temp;
    private float temp_min;
    private float temp_max;

    @Override
    public String toString() {
        return "Current Temperature: " + ((int) temp - 273) + "ºC";
    }
}
