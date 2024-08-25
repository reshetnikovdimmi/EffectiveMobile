package ru.effectivemobile.test.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.effectivemobile.test.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{


    List<Task> findByAuthorIdLikeOrExecutorIdLike(String priority, String status, Pageable pageable);
}
