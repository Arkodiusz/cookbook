package com.app.cookbook.service;

import com.app.cookbook.domain.Recipe;
import com.app.cookbook.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;

    @Test
    void findRecipeById() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        recipe1.setPortions(4L);

        //When
        Recipe savedRecipe = recipeRepository.save(recipe1);

        //Then
        assertEquals(savedRecipe, recipeService.findRecipeById(savedRecipe.getId()));
    }

    @Test
    void findAllRecipes() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Recipe recipe2 = new Recipe();
        recipe1.setName("recipe 2");
        Recipe recipe3 = new Recipe();
        recipe1.setName("recipe 3");

        //When
        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);

        //Then
        assertEquals(3, recipeService.findAllRecipes().size());
    }

    @Test
    void addRecipe() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");

        //When
        Recipe savedRecipe = recipeService.addRecipe(recipe1);

        //Then
        assertNotEquals(0, savedRecipe.getId());
        assertNotEquals(0, recipeRepository.findAll().size());
        assertEquals(savedRecipe, recipeRepository.findById(savedRecipe.getId()).get());
    }

    @Test
    void updateRecipe() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");

        //When & Then
        Recipe savedRecipe = recipeService.addRecipe(recipe1);
        assertEquals(savedRecipe, recipeRepository.findById(savedRecipe.getId()).get());

        Recipe newRecipe = recipeRepository.findById(savedRecipe.getId()).get();
        newRecipe.setName("updated recipe 1");
        recipeService.updateRecipe(newRecipe);

        assertEquals(newRecipe, recipeRepository.findById(savedRecipe.getId()).get());
    }

    @Test
    void deleteRecipe() {
        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("recipe 1");
        Recipe recipe2 = new Recipe();
        recipe1.setName("recipe 2");

        //When & Then
        recipeRepository.save(recipe1);
        Recipe savedRecipe2 = recipeRepository.save(recipe2);

        assertEquals(2, recipeRepository.findAll().size());

        recipeService.deleteRecipeById(savedRecipe2.getId());

        assertEquals(1, recipeRepository.findAll().size());
        assertFalse(recipeRepository.findAll().contains(savedRecipe2));
    }
}