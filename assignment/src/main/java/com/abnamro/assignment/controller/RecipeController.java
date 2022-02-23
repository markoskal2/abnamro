package com.abnamro.assignment.controller;

import com.abnamro.assignment.model.Recipe;
import com.abnamro.assignment.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController implements IRecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		var response = recipeService.getAllRecipes();
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
		final var recipe = recipeService.getRecipe(id);
		return ResponseEntity.ok().body(recipe);
	}

	@Override
	public ResponseEntity<Void> createRecipe(@RequestBody Recipe recipe) {
		recipeService.createRecipe(recipe);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<Void> updateRecipe(@RequestBody Recipe recipe,
											 @PathVariable Long id) {
		recipeService.updateRecipe(recipe, id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
		recipeService.deleteRecipe(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
