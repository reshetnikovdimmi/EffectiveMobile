package ru.effectivemobile.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.model.User;
import ru.effectivemobile.test.repositories.TaskRepository;
import ru.effectivemobile.test.service.interf.TaskService;

@Service
public class TaskServiceImpl extends AbstractCRUDService<Task, Long>  implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    CrudRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    @Override
    public void create(Task object) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        object.setAuthorId(currentUser.getId());
        getRepository().save(object);
    }


    @Override
    public Task update(Task object) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        object.setAuthorId(currentUser.getId());
        getRepository().save(object);
        return object;
    }
}
