package org.enspy.freello.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    // gestion des taches
    @OneToMany(mappedBy = "projet")
    private Set<Task> tasks = new HashSet<>();

    // gestion de l'admin
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User admin;

    // gestion des membres
    @ManyToMany
    @JoinTable(
        name = "project_members",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members = new HashSet<>();

    public Project() {}

    public Project(UUID id) {
        this.id = id;
    }

    public Project(String name, User admin) {
        this.name = name;
        this.admin = admin;
    }
}
