package com.tusharcodes.first.model;
import jakarta.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;


@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String name;
     private String link;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key in Project table
    private User user;  // reference from user.java file (mapped by =user)

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private ArrayList<Task> tasks = new ArrayList<>();


    public Project(){}
    @ConstructorProperties({"id","name", "link"})
   protected Project(long id,String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;

    }


    static Project of(long id, String name, String link){
        return new Project(id, name, link);
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
    public long getId() {
        return id;
    }

}
