package com.geekster.Recipe.Management.System.Repository;

import com.geekster.Recipe.Management.System.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment,Integer>
{
}
