package com.geekster.Recipe.Management.System.Controller;

import com.geekster.Recipe.Management.System.Model.Recipe;
import com.geekster.Recipe.Management.System.Service.AuthenticationTokenService;
import com.geekster.Recipe.Management.System.Service.RecipeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class RecipeController
{
    @Autowired
    RecipeService recipeService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @PostMapping("recipe")
    public  String addRecipe(@RequestBody @Valid Recipe recipe, @RequestParam String email, @RequestParam @NotBlank String token)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.addRecipe(recipe);
        }
        return "Not a Authorized User";
    }

    @GetMapping("recipe/email/{email}/token/{token}")
    public List<Recipe> getAllRecipes(@PathVariable String email,@PathVariable String token)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.getAllRecipes();
        }
        return null;
    }

    @GetMapping("recipe/name/{name}")
    public Recipe getRecipeByName(@RequestParam String email, @RequestParam @NotBlank String token, @PathVariable @NotNull String name)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.getRecipeByName(name);
        }
        return null;
    }


    @GetMapping("recipe/id/{id}")
    public Recipe getRecipeById(@RequestParam String email, @RequestParam @NotBlank String token, @PathVariable @NotNull Integer id)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.getRecipeById(id);
        }
        return null;
    }



    @PutMapping("recipe/id/{id}/instructions/{instructions}")
    public String updateInstructions(@RequestParam String email,@RequestParam String token,@PathVariable @NotNull Integer id, @PathVariable @NotNull String instructions)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.updateInstructions(email,id,instructions);
        }
        return "Not an authorized user";
    }





    @DeleteMapping("recipe/id/{id}")
    public String deleteRecipe(@RequestParam String email,@RequestParam @NotBlank String token,@PathVariable @NotNull Integer id)
    {
        if(authenticationTokenService.authenticate(email,token))
        {
            return recipeService.deleteRecipe(email,id);
        }
        return "Not an authorized user to perform an action";
    }



}
