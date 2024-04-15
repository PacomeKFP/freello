
package org.enspy.freello.model;

import java.util.List;

import org.apache.catalina.User;
import org.enspy.freello.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long taskid;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status{
        Pending,OnGoing, Completed
    }

    private List<Users> workers;

    public Task() {
    }

    public Task(long taskid, String name, String description, Status status, List<Users> workers) {
        this.taskid = taskid;
        this.name = name;
        this.description = description;
        this.status = status;
        this.workers = workers;
    }

   
    

}
