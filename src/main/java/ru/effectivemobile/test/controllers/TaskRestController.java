package ru.effectivemobile.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.service.interf.CRUDService;
import ru.effectivemobile.test.service.interf.TaskService;

import java.util.List;


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

    @PostMapping("/filt")
    public List<Task> filt(@RequestBody Task object) {

        return taskService.filt(object);
    }
}
