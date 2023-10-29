package com.geekster.Recipe.Management.System.Service;

import com.geekster.Recipe.Management.System.Model.Comment;
import com.geekster.Recipe.Management.System.Repository.ICommentRepo;
import com.geekster.Recipe.Management.System.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService
{
    @Autowired
    ICommentRepo commentRepo;

    public String addComment(Comment comment)
    {
        comment.setCommentCreationTimestamp(LocalDateTime.now());
        commentRepo.save(comment);
        return "Commented Successfully";
    }
}
