package com.app.cookbook.controller;

import com.app.cookbook.domain.Ingredient;
import com.app.cookbook.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/recipes/{recipeId}/ingredients")
    public ResponseEntity<List<Ingredient>> findAllIngredientsByRecipeId(@PathVariable("recipeId") Long recipeId) {
        return new ResponseEntity<>(ingredientService.findAllIngredientsByRecipeId(recipeId), HttpStatus.OK);
    }

    @PostMapping("/recipes/{recipeId}/ingredients")
    public ResponseEntity<Ingredient> addIngredientToRecipe(@PathVariable("recipeId") Long recipeId, @RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredientService.addIngredientToRecipe(recipeId, ingredient), HttpStatus.CREATED);
    }

    @PutMapping("/recipes/{recipeId}/ingredients/{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredientInRecipe(@PathVariable("recipeId") Long recipeId, @PathVariable("ingredientId") Long ingredientId, @RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredientService.updateIngredientInRecipe(recipeId, ingredientId, ingredient), HttpStatus.OK);
    }

    @DeleteMapping("/recipes/{recipeId}/ingredients/{ingredientId}")
    public ResponseEntity<?> deleteIngredientById(@PathVariable("recipeId") Long recipeId, @PathVariable("ingredientId") Long ingredientId) {
        return ingredientService.deleteIngredientByRecipeIdAndIngredientId(recipeId, ingredientId);
    }
}
