package com.app.cookbook.controller;

import com.app.cookbook.domain.Recipe;
import com.app.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> findAllRecipes() {
        return new ResponseEntity<>(recipeService.findAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> findRecipeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(recipeService.findRecipeById(id), HttpStatus.OK);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.addRecipe(recipe), HttpStatus.CREATED);
    }

    @PutMapping("/recipes")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.updateRecipe(recipe), HttpStatus.OK);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<?> deleteRecipeById(@PathVariable("id") Long id) {
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
