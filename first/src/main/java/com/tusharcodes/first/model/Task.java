package com.tusharcodes.first.model;
import jakarta.persistence.*;
import lombok.*;
import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private int priority;

    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

   // @ConstructorProperties({"id","title","description","Status","priority","LocalDate"})

  /*  private Task(long id, @NonNull String title, String description, Status status, int priority, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;

    }
    static Task of(long id,@NonNull String title, String description, Status status, int priority, LocalDate deadline) {
        return new Task(id, title, description, status, priority, deadline);
    }*/
    //getter functions

}

