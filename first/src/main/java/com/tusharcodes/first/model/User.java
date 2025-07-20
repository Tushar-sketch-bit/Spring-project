package com.tusharcodes.first.model;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.*;


import java.beans.ConstructorProperties;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final private long id;
    @NonNull
    String name;
    @NonNull
    private String email;
    @NonNull
    private String password;


    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Project> projects;

    @Enumerated(EnumType.STRING)
    private Role role;

   /* @ConstructorProperties({"id","email","password","projects"})
    private User(long id, String username, String email, List<Project> projects){
        this.id = id;
        this.username = username;
        this.email = email;
        this.projects = projects;
    }*/

    public static User of(long id,@NonNull String name, @NonNull String password, @NonNull String email, List<Project> projects,Role role) {
        return new User(id,name, password, email, projects,role);
    }






}
