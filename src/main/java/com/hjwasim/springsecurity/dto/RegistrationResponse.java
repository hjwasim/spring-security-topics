package com.hjwasim.springsecurity.dto;

public class RegistrationResponse extends BaseResponse {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
