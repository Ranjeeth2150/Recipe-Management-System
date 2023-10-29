package com.geekster.Recipe.Management.System.Repository;

import com.geekster.Recipe.Management.System.Model.AuthenticationToken;
import com.geekster.Recipe.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long>
{

    AuthenticationToken findFirstByTokenValue(String authToken);

    AuthenticationToken findFirstByUser(User user);
}
