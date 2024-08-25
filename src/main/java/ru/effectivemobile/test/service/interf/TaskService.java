package ru.effectivemobile.test.service.interf;

import org.hibernate.query.Page;
import ru.effectivemobile.test.model.Task;

import java.util.List;

public interface TaskService extends CRUDService<Task, Long>{
    List<Task> filt (Task obj);
}
