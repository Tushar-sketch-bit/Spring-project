package com.tusharcodes.first.model;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.beans.ConstructorProperties;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class User implements UserDetails {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
