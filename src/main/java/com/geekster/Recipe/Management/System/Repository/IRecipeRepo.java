package com.geekster.Recipe.Management.System.Repository;

import com.geekster.Recipe.Management.System.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepo extends JpaRepository<Recipe,Integer> {
    Recipe findByName(String name);
}
