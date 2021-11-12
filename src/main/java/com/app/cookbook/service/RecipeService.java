package com.app.cookbook.service;

import com.app.cookbook.domain.Recipe;
import com.app.cookbook.exception.ResourceNotFoundException;
import com.app.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id " + id + " not found"));
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Long id) {
        if(!recipeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recipe with id " + id + " not found");
        }
        recipeRepository.deleteById(id);
    }
}
