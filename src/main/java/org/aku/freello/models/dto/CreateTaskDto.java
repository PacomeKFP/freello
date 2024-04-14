package org.aku.freello.models.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateTaskDto {
    private UUID id;
    private String name;
    private String description;
}
