package org.enspy.freello.models.dto;

import java.util.UUID;

import org.enspy.freello.models.User;

import lombok.Getter;

@Getter
public class CreateProjectDto {
    private String name;
    private UUID admin;

    public User getAdminAsUser() {
        return new User(admin);
    }
}
