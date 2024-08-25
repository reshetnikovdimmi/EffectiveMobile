package ru.effectivemobile.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.effectivemobile.test.model.Comments;
import ru.effectivemobile.test.service.interf.CRUDService;
import ru.effectivemobile.test.service.interf.CommentsService;


@RestController
@RequestMapping(CommentsRestController.COMMENTS_REST_URL)
public class CommentsRestController extends CRUDRestController<Comments, Long>{

    @Autowired
    private CommentsService commentsService;
    public static final String COMMENTS_REST_URL = "comments";

    @Override
    CRUDService<Comments, Long> getService() {
        return commentsService;
    }
}
