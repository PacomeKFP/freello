package org.aku.freello.models.dto;

import lombok.Getter;
import org.aku.freello.models.User;

import java.util.UUID;

@Getter
public class UpdateProjectDto {
    private String name;
    private UUID admin;
    public User getAdminAsUser() {
        return new User(admin);
    }
}
