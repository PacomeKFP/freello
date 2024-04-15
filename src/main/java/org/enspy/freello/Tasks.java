/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.enspy.freello;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Tasks {
    private long taskID;
    private String Title;
    private String Description;
    private enum Status {Pending,Ongoing,Completed}
    private Date due_date;
    private Users[] workers;
    
}
