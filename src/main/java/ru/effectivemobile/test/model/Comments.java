package ru.effectivemobile.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String comments;
    private Long authorId;
    private Long taskId;
}
