package org.enspy.freelo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    private User admin;

    @ManyToMany
    private Set<User> members;

    public Project(String name, UUID admin) {
    }

    public Project() {

    }
}
