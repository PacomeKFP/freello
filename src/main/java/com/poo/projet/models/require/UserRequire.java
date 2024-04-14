package com.poo.projet.models.require;

import jakarta.validation.constraints.NotEmpty;


public class UserRequire {

    @NotEmpty(message = "the name is required")
    private String name;

    @NotEmpty(message = "the email is required")
    private String email;

    @NotEmpty(message = "the password is required")

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password;

}
