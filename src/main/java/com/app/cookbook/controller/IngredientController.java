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
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    @GetMapping("/find/all")
    public ResponseEntity<List<Ingredient>> findAllIngredients() {
        return new ResponseEntity<>(ingredientService.findAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Ingredient> findIngredientById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(ingredientService.findIngredientById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredientService.addIngredient(ingredient), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredientService.updateIngredient(ingredient), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIngredientById(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
