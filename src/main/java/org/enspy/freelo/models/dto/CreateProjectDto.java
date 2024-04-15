package org.enspy.freelo.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProjectDto {
    private String name;
    private UUID admin;
}
