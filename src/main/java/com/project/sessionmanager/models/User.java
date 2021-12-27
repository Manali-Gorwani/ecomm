package com.project.sessionmanager.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String username;
    String password;
    String emailid;
    String role;
    @ColumnDefault("true")
    String status="ACTIVE";



    public User() {
    }

    public User(String username, String password, String emailid, String role) {
        this.username = username;
        this.password = password;
        this.emailid = emailid;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }


}
