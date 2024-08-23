package ru.effectivemobile.test.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String heading;
    private String description;
    private String status;
    private String priority;
    private Long authorId;
    private Long executorId;

    @OneToMany(targetEntity = Comments.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "taskId",referencedColumnName = "id", insertable = false, updatable = false)
    private List<Comments> commentsList;

}
