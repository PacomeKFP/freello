package org.aku.freello.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateTaskDto {
    private UUID id;
    private String name;
    private String description;
}
