package com.poo.projet.models.require;

import jakarta.validation.constraints.NotEmpty;

public class ProjectRequire {

    @NotEmpty(message = "the name is required")
    public String name;
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
