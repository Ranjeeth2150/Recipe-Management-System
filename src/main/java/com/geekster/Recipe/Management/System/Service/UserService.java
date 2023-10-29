package com.geekster.Recipe.Management.System.Service;

import com.geekster.Recipe.Management.System.Model.AuthenticationToken;
import com.geekster.Recipe.Management.System.Model.User;
import com.geekster.Recipe.Management.System.Repository.IAuthenticationRepo;
import com.geekster.Recipe.Management.System.Repository.IUserRepo;
import com.geekster.Recipe.Management.System.Service.Utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService
{
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public String signUpUser(User user)
    {
        String newEmail=user.getEmail();
        if(newEmail==null)
        {
            return "Invalid email";
        }
        User existingUser=iUserRepo.findFirstByEmail(newEmail);

        if(existingUser != null)
        {
            return "User already registered,please SignIn ";
        }
        try
        {
            String encryptedPassword= PasswordEncrypter.encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            iUserRepo.save(user);
            return "User Register Successfully and your id is "+user.getId();
        } catch (Exception e) {
            return "Internal error,Please Try Again to SignUp";
        }
    }

    public String signInUser(String userEmail, String password)
    {
        if(userEmail==null)
        {
            return "invalid email";
        }
        //check if user is exits or not

        User existingUser=iUserRepo.findFirstByEmail(userEmail);
        if(existingUser==null)
        {
            return "User not yet registered";

        }
        try
        {
            String encryptedPassword=PasswordEncrypter.encryptPassword(password);
            if(existingUser.getPassword().equals(encryptedPassword))
            {
                AuthenticationToken authenticationToken=new AuthenticationToken(existingUser);
                authenticationTokenService.save(authenticationToken);

                return "User signed In Success,"+"/n Token value is "+authenticationToken.getTokenValue();
            }
            else
            {
                return "Invalid UserEmail or Password";
            }
        }catch (Exception e)
        {
            return "You have already Signned In";
        }

    }


    public String signOut(String userEmail)
    {
        User user=iUserRepo.findFirstByEmail(userEmail);
        AuthenticationToken authenticationToken=authenticationTokenService.findFirstByUser(user);
        authenticationTokenService.delete(authenticationToken);
        return "Sign out Successfully";
    }

    public User findFirstByEmail(String email)
    {
        return iUserRepo.findFirstByEmail(email);
    }
}
