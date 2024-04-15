package com.poo.projet.models.require;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TaskRequire {

    @NotEmpty(message = "the name is required")
    public String title;

    @NotEmpty(message = "the status is required")

    @Size(min = 10, message = "the description must be at least 10 characters")
    @Size(max = 2000, message = "the description cannot exceed 2000 characters")
    private String description;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
