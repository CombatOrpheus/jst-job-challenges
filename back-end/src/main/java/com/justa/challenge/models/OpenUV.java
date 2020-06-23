package com.justa.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @ToString @Getter
public class OpenUV {

    private float uv;
    private String uv_time;
    //TODO Request must have an 'x-access-token' header, has to be added manually
}
