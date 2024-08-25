package ru.effectivemobile.test.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.effectivemobile.test.model.Task;
import ru.effectivemobile.test.model.User;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void addTask() {
        Task task = new Task();
        task.setDescription("Description");
        task.setHeading("Heading");
        Task newTask = taskRepository.save(task);
        assertTrue(newTask.getId()>0);
    }
}