package br.com.jax.ws.rs.controller.login.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
public class LoginDTO {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
