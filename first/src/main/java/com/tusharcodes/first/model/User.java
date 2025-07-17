package com.tusharcodes.first.model;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.*;

import java.beans.ConstructorProperties;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final private long id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Project> projects;

   /* @ConstructorProperties({"id","username","email","projects"})
    private User(long id, String username, String email, List<Project> projects){
        this.id = id;
        this.username = username;
        this.email = email;
        this.projects = projects;
    }*/

    public static User of(long id, @NonNull String username, @NonNull String email, List<Project> projects){
        return new User(id, username, email, projects);
    }






}
