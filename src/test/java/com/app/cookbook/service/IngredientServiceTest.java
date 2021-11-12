package com.app.cookbook.service;

import com.app.cookbook.domain.Ingredient;
import com.app.cookbook.domain.Recipe;
import com.app.cookbook.repository.IngredientRepository;
import com.app.cookbook.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class IngredientServiceTest {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientService ingredientService;

    @Test
    void findAllIngredientsByRecipeId() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("ingredient 1");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("ingredient 2");
        Ingredient ingredient3 = new Ingredient();
        ingredient2.setName("ingredient 3");

        //When
        Recipe savedRecipe = recipeRepository.save(recipe1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient2);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient3);

        //Then
        assertEquals(3, ingredientService.findAllIngredientsByRecipeId(savedRecipe.getId()).size());
        assertTrue(ingredientService.findAllIngredientsByRecipeId(savedRecipe.getId()).containsAll(List.of(ingredient1, ingredient2, ingredient3)));

    }

    @Test
    void addIngredientToRecipe() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("ingredient 1");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("ingredient 2");

        //When
        Recipe savedRecipe = recipeRepository.save(recipe1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient2);

        //Then
        assertTrue(ingredientRepository.findByRecipeId(savedRecipe.getId()).containsAll(List.of(ingredient1, ingredient2)));
    }

    @Test
    void updateIngredientInRecipe() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("ingredient 1");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("ingredient 2");

        //When
        Recipe savedRecipe = recipeRepository.save(recipe1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient1);
        Ingredient savedIngredient = ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient2);
        Ingredient newIngredient = savedIngredient;
        newIngredient.setName("updated ingredient 2");
        ingredientService.updateIngredientInRecipe(savedRecipe.getId(), savedIngredient.getId(), newIngredient);

        //Then
        assertEquals(newIngredient, ingredientRepository.findByIdAndRecipeId(savedIngredient.getId(), savedRecipe.getId()).get());
    }

    @Test
    void deleteIngredientByRecipeIdAndIngredientId() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("ingredient 1");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("ingredient 2");

        //When & Then
        Recipe savedRecipe = recipeRepository.save(recipe1);
        ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient1);
        Ingredient savedIngredient = ingredientService.addIngredientToRecipe(savedRecipe.getId(), ingredient2);

        assertEquals(2, ingredientRepository.findByRecipeId(savedRecipe.getId()).size());
        assertTrue(ingredientRepository.findByRecipeId(savedRecipe.getId()).contains(savedIngredient));

        ingredientService.deleteIngredientByRecipeIdAndIngredientId(savedRecipe.getId(), savedIngredient.getId());

        assertEquals(1, ingredientRepository.findByRecipeId(savedRecipe.getId()).size());
        assertFalse(ingredientRepository.findByRecipeId(savedRecipe.getId()).contains(savedIngredient));
    }
}