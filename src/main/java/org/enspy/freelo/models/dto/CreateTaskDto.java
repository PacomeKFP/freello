package org.enspy.freelo.models.dto;

import lombok.Getter;


import java.util.UUID;

@Getter

public class CreateTaskDto {
    private String title;
    private String description;
    private UUID project;

}
