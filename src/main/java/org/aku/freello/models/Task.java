package org.aku.freello.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    public Task() {}

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @ManyToOne
    Project project;

    @ManyToMany
    Set<User> collaborators;

}
