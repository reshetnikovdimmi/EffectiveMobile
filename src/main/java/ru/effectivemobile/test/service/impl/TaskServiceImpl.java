package ru.effectivemobile.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.effectivemobile.test.dtos.FilterDto;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.model.User;
import ru.effectivemobile.test.repositories.TaskRepository;
import ru.effectivemobile.test.service.interf.TaskService;

import java.util.List;

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
        object.setId(currentUser().getId());
        getRepository().save(object);
    }

    @Override
    public Task update(Task object) {
        if(object.getAuthorId().equals(currentUser().getId()))
            getRepository().save(object);
        return object;
    }

    @Override
    public List <Task> filt(FilterDto obj) {
        Pageable pageable = PageRequest.of(Math.toIntExact(obj.getPageNumber()), 3);
        List<Task> tasks = taskRepository.findByAuthorIdLikeOrExecutorIdLike(obj.getAuthorId(), obj.getExecutorId(),pageable);
        return  tasks;
    }

    private User currentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
