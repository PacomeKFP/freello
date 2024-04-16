package org.enspy.freello.models.dto;

import java.util.UUID;

import org.enspy.freello.models.Project;

import lombok.Getter;
@Getter
public class CreateTaskDto {

    private String title;
    private String description;
    private UUID project;

    public Project getProjectAsProject() {
        return new Project(project);
    }
}
