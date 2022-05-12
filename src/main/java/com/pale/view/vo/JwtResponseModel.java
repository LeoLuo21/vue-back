package com.pale.view.vo;

public class JwtResponseModel {
    private String token;

    public JwtResponseModel() {
    }

    public JwtResponseModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
