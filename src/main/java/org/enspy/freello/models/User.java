package org.enspy.freello.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    // admin du projet
    @OneToMany(mappedBy = "admin")
    private Set<Project> projects = new HashSet<>();

    // membres du projet
    @ManyToMany(mappedBy = "members")
    private Set<Project> memberProjects = new HashSet<>();

    // membres du projet
    @ManyToMany(mappedBy = "collaborators")
    private Set<Task> collaboratorsTask = new HashSet<>();

    public User() {}

    public User(UUID id) {
        this.id = id;
    }
}
