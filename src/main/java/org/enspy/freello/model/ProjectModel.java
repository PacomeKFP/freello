package org.enspy.freello.model;

import org.enspy.freello.Users;
import org.enspy.freello.Projects;

public class ProjectModel {

    private long projectID;
    private String name;
    private Users admin;
    private Users members[];


    public ProjectModel(long projectID, String name, Users admin, Users[] members) {
        this.projectID = projectID;
        this.name = name;
        this.admin = admin;
        this.members = members;
    }



}
