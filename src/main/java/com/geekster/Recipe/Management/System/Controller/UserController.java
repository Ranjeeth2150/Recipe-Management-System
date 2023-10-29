package com.geekster.Recipe.Management.System.Controller;

import com.geekster.Recipe.Management.System.Model.User;
import com.geekster.Recipe.Management.System.Service.AuthenticationTokenService;
import com.geekster.Recipe.Management.System.Service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    //signUp
    @PostMapping("user/signup")
    public String signUpUser(@RequestBody @Valid User user)
    {
        return userService.signUpUser(user);
    }


    //signIn
    @PostMapping("user/signIn")
    public String signInUser(@RequestParam  @Pattern(regexp = "^\\w+@gmail\\.com$") String userEmail, @RequestParam @NotBlank String password)
    {
        return userService.signInUser(userEmail,password);
    }


    //signOut
    @DeleteMapping("user/signOut")
    public String signOut(@RequestParam  @Pattern(regexp = "^\\w+@gmail\\.com$") String userEmail, @RequestParam @NotBlank String authToken)
    {
        if(authenticationTokenService.authenticate(userEmail,authToken))
        {
            return userService.signOut(userEmail);
        }
        else
        {
            return "Invalid Token Value or User have not yet Signed In";
        }
    }



}
