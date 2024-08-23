package ru.effectivemobile.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.effectivemobile.test.model.Comments;
import ru.effectivemobile.test.repositories.CommentsRepository;
import ru.effectivemobile.test.service.interf.CommentsService;

@Service
public class CommentsServiceImpl extends AbstractCRUDService<Comments, Long>  implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    CrudRepository<Comments, Long> getRepository() {
        return commentsRepository;
    }
}
