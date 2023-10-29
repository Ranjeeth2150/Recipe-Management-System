package com.geekster.Recipe.Management.System.Service;

import com.geekster.Recipe.Management.System.Model.AuthenticationToken;
import com.geekster.Recipe.Management.System.Model.User;
import com.geekster.Recipe.Management.System.Repository.IAuthenticationRepo;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService
{
    @Autowired
    IAuthenticationRepo iAuthenticationRepo;


    public void save(AuthenticationToken authenticationToken)
    {
        iAuthenticationRepo.save(authenticationToken);
    }

    public boolean authenticate(String userEmail, String authTokenValue)
    {
       AuthenticationToken authToken=iAuthenticationRepo.findFirstByTokenValue(authTokenValue);

       if(authToken==null)
       {
           return false;

       }
       String tokenEmail=authToken.getUser().getEmail();
       return tokenEmail.equals(userEmail);

    }



    public AuthenticationToken findFirstByUser(User user)
    {
        return iAuthenticationRepo.findFirstByUser(user);
    }

    public void delete(AuthenticationToken authenticationToken)
    {
        iAuthenticationRepo.delete(authenticationToken);
    }
}
