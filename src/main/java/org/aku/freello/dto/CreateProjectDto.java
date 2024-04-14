package org.aku.freello.dto;

import lombok.Getter;
import org.aku.freello.models.User;

import java.util.UUID;

@Getter
public class CreateProjectDto {
    private String name;
    UUID admin;

    public User getAdminAsUser() {
        return new User(admin);
    }
}
