package org.enspy.freello.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, ONGOING, COMPLETED
    }

    @ManyToMany
    @JoinTable(
            name = "user_tasks",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )

    private List<Users> workers;
    @ManyToMany
    private List<Users> collaborators;

    public List<Users> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Users> collaborators) {
        this.collaborators = collaborators;
    }

    @Column(name = "due_date")
    private java.sql.Date dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Users> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Users> workers) {
        this.workers = workers;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
