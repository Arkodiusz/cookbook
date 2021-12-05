package com.app.cookbook.service;

import com.app.cookbook.domain.Ingredient;
import com.app.cookbook.exception.ResourceNotFoundException;
import com.app.cookbook.repository.IngredientRepository;
import com.app.cookbook.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public List<Ingredient> findAllIngredientsByRecipeId(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId);
    }

    public Ingredient findIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        return ingredientRepository.findByIdAndRecipeId(ingredientId, recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient with id " + ingredientId + " and recipeId " + recipeId + " not found"));
    }

    public Ingredient addIngredientToRecipe(Long recipeId, Ingredient ingredient) {
        return recipeRepository.findById(recipeId).map(recipe -> {
            ingredient.setRecipe(recipe);
            return ingredientRepository.save(ingredient);
        }).orElseThrow(() -> new ResourceNotFoundException("Recipe with id " + recipeId + " not found"));
    }

    public List<Ingredient> addIngredientsToRecipe(Long recipeId, List<Ingredient> ingredients) {
        return recipeRepository.findById(recipeId).map(recipe -> {
            for (Ingredient ingredient : ingredients) {
                ingredient.setRecipe(recipe);
            }
            return ingredientRepository.saveAll(ingredients);
        }).orElseThrow(() -> new ResourceNotFoundException("Recipe with id " + recipeId + " not found"));
    }

    public Ingredient updateIngredientInRecipe(Long recipeId, Long ingredientId, Ingredient ingredientRequest) {
        if(!recipeRepository.existsById(recipeId)) {
            throw new ResourceNotFoundException("Recipe with id " + recipeId + " not found");
        }
        return ingredientRepository.findById(ingredientId).map(ingredient -> {
            ingredient.setName(ingredientRequest.getName());
            ingredient.setQuantity(ingredientRequest.getQuantity());
            ingredient.setUnit(ingredientRequest.getUnit());
            return ingredientRepository.save(ingredient);
        }).orElseThrow(() -> new ResourceNotFoundException("Ingredient with id " + ingredientId + " not found"));
    }

    public ResponseEntity<?> deleteIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        return ingredientRepository.findByIdAndRecipeId(ingredientId, recipeId).map(ingredient -> {
            ingredientRepository.delete(ingredient);
            return new ResponseEntity<>(HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Ingredient with id " + ingredientId + " and recipeId " + recipeId + " not found"));
    }
}

