package org.enspy.freelo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto{
    private String name;
    private String password;
}
