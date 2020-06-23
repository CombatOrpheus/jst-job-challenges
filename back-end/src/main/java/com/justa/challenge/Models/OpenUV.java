package com.justa.challenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @ToString @Getter
public class OpenUV {

    private float uv;
    private String uv_time;
}
