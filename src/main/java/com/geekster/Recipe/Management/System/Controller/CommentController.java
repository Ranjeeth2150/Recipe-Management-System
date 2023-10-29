package com.geekster.Recipe.Management.System.Controller;

import com.geekster.Recipe.Management.System.Model.Comment;
import com.geekster.Recipe.Management.System.Service.AuthenticationTokenService;
import com.geekster.Recipe.Management.System.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CommentController
{
    @Autowired
    CommentService commentService;
    @Autowired
    AuthenticationTokenService authenticationTokenService;
    @PostMapping("comments")
    public String addComment(@RequestBody @Valid Comment comment){
        return commentService.addComment(comment);
    }
}
