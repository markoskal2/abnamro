package com.abnamro.assignment.service;

import com.abnamro.assignment.assembler.RecipeAssembler;
import com.abnamro.assignment.entity.RecipeEntity;
import com.abnamro.assignment.model.Recipe;
import com.abnamro.assignment.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeAssembler recipeAssembler;

	public RecipeService(RecipeRepository recipeRepository, RecipeAssembler recipeAssembler) {
		this.recipeRepository = recipeRepository;
		this.recipeAssembler = recipeAssembler;
	}

	public Recipe getRecipe(final long id) {

		final var recipeEntity = recipeRepository.findById(id);

		if (recipeEntity.isEmpty()) {
			throw new RuntimeException("Recipe not found");
		}

		return recipeAssembler.assembleRecipe(recipeEntity.get());
	}

	public Recipe createRecipe(Recipe recipe) {
		final var recipeEntity = recipeAssembler.toModel(recipe);

		try {
			return recipeAssembler.assembleRecipe(recipeRepository.save(recipeEntity));
		}
		catch (DataIntegrityViolationException e) {
			log.error("Creating the recipe failed");
			throw new RuntimeException(e);
		}
	}

	public RecipeEntity updateRecipe(Recipe recipe, long id) {
		var foundRecipe = recipeRepository.findById(id);
		if (foundRecipe.isEmpty()) {
			throw new RuntimeException("Recipe you want to update not found");
		}

		final var recipeEntity = recipeAssembler.toModel(recipe);

		try {
			return recipeRepository.save(recipeEntity);
		}
		catch (DataIntegrityViolationException e) {
			log.error("Updating the recipe failed");
			throw new RuntimeException(e);
		}
	}

	public void deleteRecipe(long id) {
		try {
			recipeRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			log.error("Deleting the recipe failed");
			throw new RuntimeException(e);
		}
	}

	public List<Recipe> getAllRecipes() {
		List<RecipeEntity> recipeEntities = recipeRepository.findAll();

		List<Recipe> recipesList = new ArrayList<>();
		recipeEntities.forEach(r -> recipesList.add(recipeAssembler.assembleRecipe(r)));

		return recipesList;
	}

}
