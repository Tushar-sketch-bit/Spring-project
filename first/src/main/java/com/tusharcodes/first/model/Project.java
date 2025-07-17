package com.tusharcodes.first.model;
import jakarta.persistence.*;
import lombok.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     final private long id;
     @NonNull
     private String name;
     private String link;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key in Project table
    private User user;  // reference from user.java file (mapped by =user)

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private ArrayList<Task> tasks = new ArrayList<>();


    @ConstructorProperties({"id","name", "link"})
    protected Project(long id,@NonNull String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;

    }

   public static Project of(long id, String name, String link){
        return new Project(id, name, link);
    }


}
