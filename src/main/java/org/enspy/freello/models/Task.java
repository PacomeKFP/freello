package org.enspy.freello.models;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @ManyToOne
    private Project project;

    @ManyToMany
    private Set<User> workers;

    public Task() {}

    public Task(String title, String description, String status, Date createdAt, Project project) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.project = project;
    }

}
