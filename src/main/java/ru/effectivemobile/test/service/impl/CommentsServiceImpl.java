package ru.effectivemobile.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.effectivemobile.test.model.Comments;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.model.User;
import ru.effectivemobile.test.repositories.CommentsRepository;
import ru.effectivemobile.test.service.interf.CommentsService;

import java.util.stream.Collectors;

@Service
public class CommentsServiceImpl extends AbstractCRUDService<Comments, Long>  implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    CrudRepository<Comments, Long> getRepository() {
        return commentsRepository;
    }

    @Override
    public Comments update(Comments object) {
        if(object.getAuthorId().equals(currentUser().getId()))
            getRepository().save(object);
        return object;
    }

    private User currentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
