/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.enspy.freello.model;


/**
 *
 * @author User
 */
public class UsersModel {
    private long userID;
    private String name;
    private String email;
    private String password;
    
    public UsersModel(long userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    
    
}
