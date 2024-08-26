package ru.effectivemobile.test.service.interf;

import ru.effectivemobile.test.dtos.FilterDto;
import ru.effectivemobile.test.model.Task;

import java.util.List;

public interface TaskService extends CRUDService<Task, Long>{
    List<Task> filt (FilterDto obj);
}
