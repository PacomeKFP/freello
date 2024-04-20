package org.enspy.freello.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String status;

    @Column(name = "createdAt")
    private Date createdAt;

    // gestion des projets
    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Project projet;

    // gestion des membres
    @ManyToMany
    @JoinTable(
        name = "task_collaborator",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> collaborators = new HashSet<>();

    public Task() {}

    public Task(String title, String description, String status, Date createdAt, Project project) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.projet = project;
    }

}
