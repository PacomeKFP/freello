package com.poo.projet.models;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_t;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private enum Status {
        ON_GOING,
        PENDING,
        COMPLETED
    }

    private Status status;

    @Column(name = "created_at")
    private Date createdAt;

    public UUID getId_t() {
        return this.id_t;
    }

    public void setId_t(UUID id_t) {
        this.id_t = id_t;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
