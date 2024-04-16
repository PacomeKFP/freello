package org.enspy.freello.models.dto;

import lombok.Getter;

@Getter
public class CreateUserDto {

    private String name;
    private String email;
    private String password;
}
