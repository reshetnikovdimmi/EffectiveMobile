package ru.effectivemobile.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.effectivemobile.test.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{

}
