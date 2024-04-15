package org.enspy.freello.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="ProjectModel")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectID;
    private String name;

    

    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status{
        Pending,OnGoing, Completed
    }

    


    



}
