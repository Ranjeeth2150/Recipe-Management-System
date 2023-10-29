package com.geekster.Recipe.Management.System.Service;

import com.geekster.Recipe.Management.System.Model.Recipe;
import com.geekster.Recipe.Management.System.Model.User;
import com.geekster.Recipe.Management.System.Repository.IRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService
{
    @Autowired
    IRecipeRepo iRecipeRepo;
    @Autowired
    UserService userService;

    public String addRecipe(Recipe recipe)
    {
        recipe.setRecipeCreationTimeStamp(LocalDateTime.now());
        iRecipeRepo.save(recipe);
        return "recipe added successfully";
    }

    public List<Recipe> getAllRecipes()
    {
        return iRecipeRepo.findAll();
    }

    public Recipe getRecipeByName(String name)
    {
        return iRecipeRepo.findByName(name);
    }

    public Recipe getRecipeById(Integer id)
    {
        return iRecipeRepo.findById(id).orElse(null);
    }

    public String deleteRecipe(String email, Integer id)
    {
        //User user=userService.findFirstByEmail(email);
        User user=userService.findFirstByEmail(email);
        Recipe recipe=iRecipeRepo.findById(id).orElse(null);

        if(recipe != null)
        {
            if(recipe.getUser().equals(user))
            {
                iRecipeRepo.delete(recipe);
                return "Recipe for id "+id+" deleted successfully";
            }
            else
            {
                return "You are not authorized User to delete the recipe ";
            }

        }
        return "Recipe Not Found with provided id";
    }


    public String updateInstructions(String email, Integer id, String instructions)
    {
        User user=userService.findFirstByEmail(email);
        Recipe recipe=iRecipeRepo.findById(id).orElse(null);

        if(recipe != null)
        {
            if(recipe.getUser().equals(user))
            {
                recipe.setInstructions(instructions);
                iRecipeRepo.save(recipe);
                return "Instructions are updated successfully for "+recipe.getName()+" Recipe";
            }
            else
            {
                return "You are not authorized User to update the recipe ";
            }

        }
        return "Recipe Not Found with provided id";
    }
}
