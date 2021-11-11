package com.app.cookbook.repository;

import com.app.cookbook.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
