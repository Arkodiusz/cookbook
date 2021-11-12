package com.app.cookbook;

import com.app.cookbook.controller.IngredientController;
import com.app.cookbook.controller.RecipeController;
import com.app.cookbook.service.IngredientService;
import com.app.cookbook.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CookbookApplicationTests {

	@Autowired
	private RecipeController recipeController;
	@Autowired
	private RecipeService recipeService;
	@Autowired
	private IngredientController ingredientController;
	@Autowired
	private IngredientService ingredientService;

	@Test
	void contextLoads() {
		assertNotNull(recipeController);
		assertNotNull(recipeService);
		assertNotNull(ingredientController);
		assertNotNull(ingredientService);
	}
}
