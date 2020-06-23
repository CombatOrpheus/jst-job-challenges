package com.justa.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @Getter @Setter @ToString
public class MainStats {

    private float temp;
    private float temp_min;
    private float temp_max;
}
