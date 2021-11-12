package com.app.cookbook.repository;

import com.app.cookbook.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
