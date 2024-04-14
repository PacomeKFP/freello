package org.aku.freello.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToOne
    User admin;

    @ManyToMany
    private Set<User> members;

    public Project() {
    }

    public Project(String name, User admin) {
        this.name = name;
        this.admin = admin;
        this.members = new HashSet<>();
        this.members.add(admin);
    }


}
