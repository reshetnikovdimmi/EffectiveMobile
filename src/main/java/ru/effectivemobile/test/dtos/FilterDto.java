package ru.effectivemobile.test.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {
    private Long authorId;
    private Long executorId;
    private Long pageNumber;
}
