package org.enspy.freelo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.enspy.freelo.services.ProjectService;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;

    @ManyToOne
    private Project project;
    @ManyToMany
    private Set<User> workers;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "due_date")
    private java.sql.Date dueDate;
    public Task(String name, String description) {
    }

    public Task() {

    }

    @ManyToMany
    private Set<User> collaborators;
    public enum Status{
        PENDING, ONGOING,COMPLETED
    }

}
