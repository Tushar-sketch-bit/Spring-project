package com.tusharcodes.first.model;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

import java.beans.ConstructorProperties;
import java.util.List;
import com.tusharcodes.first.model.Project;

@Entity
public class User {
    @Id
    private long id;
    private String username;
    private String email;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Project> projects;

    public User(){

    }
    @ConstructorProperties({"id","username","email","projects"})
    private User(long id, String username, String email, List<Project> projects){
        this.id = id;
        this.username = username;
        this.email = email;
        this.projects = projects;
    }

    public static User of(long id, String username, String email, List<Project> projects){
        return new User(id, username, email, projects);
    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public List<Project> getProjects(){
        return projects;
    }




}
