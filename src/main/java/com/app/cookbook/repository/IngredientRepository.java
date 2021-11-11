package com.app.cookbook.repository;

import com.app.cookbook.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipeId);
    Optional<Ingredient> findByIdAndRecipeId(Long id, Long recipeId);
}
