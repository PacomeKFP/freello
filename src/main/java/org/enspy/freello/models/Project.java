package org.enspy.freello.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    public Project() {}

    public Project(UUID id) {
        this.id = id;
    }

    // public Project(String name, User admin) {
    //     this.name = name;
    //     this.members = new HashSet<>();
    //     this.members.add(admin.getEmail());
    // }

    public Project(String name, User admin) {
        this.name = name;
        this.members = new HashSet<>();
        this.members.add(admin);
    }
}
