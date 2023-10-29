package com.geekster.Recipe.Management.System.Repository;

import com.geekster.Recipe.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String newEmail);

    String findById(User user);
}
