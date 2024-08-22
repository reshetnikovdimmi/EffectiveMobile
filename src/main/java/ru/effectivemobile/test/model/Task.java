package ru.effectivemobile.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

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
}
