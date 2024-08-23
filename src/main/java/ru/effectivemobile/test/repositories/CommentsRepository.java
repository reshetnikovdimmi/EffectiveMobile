package ru.effectivemobile.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.effectivemobile.test.model.Comments;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
}
