package ru.effectivemobile.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.service.interf.CRUDService;
import ru.effectivemobile.test.service.interf.TaskService;


@RestController
@RequestMapping(TaskRestController.TASK_REST_URL)
public class TaskRestController extends CRUDRestController<Task, Long> {
    @Autowired
    private TaskService taskService;
    public static final String TASK_REST_URL = "task";

    @Override
    CRUDService<Task, Long> getService() {
        return taskService;
    }
}
