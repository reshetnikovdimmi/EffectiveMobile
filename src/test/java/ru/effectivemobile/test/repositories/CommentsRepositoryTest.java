package ru.effectivemobile.test.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.effectivemobile.test.model.Comments;
import ru.effectivemobile.test.model.Task;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class CommentsRepositoryTest {
    @Autowired
    private CommentsRepository commentsRepository;

    @Test
    public void addComments() {
        Comments comments = new Comments();
        comments.setComments("Comments");
        comments.setAuthorId(202L);
        Comments newComments = commentsRepository.save(comments);
        assertTrue(newComments.getId()>0);
    }
}