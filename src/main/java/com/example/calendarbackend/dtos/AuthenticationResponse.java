package com.example.calendarbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
    
    @JsonProperty("jwt")
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
