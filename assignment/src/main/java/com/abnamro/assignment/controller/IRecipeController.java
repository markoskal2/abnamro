package com.abnamro.assignment.controller;

import com.abnamro.assignment.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recipes")
public interface IRecipeController {

	/**
	 * Gets the all recipe
	 *
	 * @return the all
	 */
	@GetMapping("/all")
	ResponseEntity<List<Recipe>> getAllRecipes();

	/**
	 * This method returns unique recipe by id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	ResponseEntity<Recipe> getRecipe(@PathVariable Long id);

	/**
	 * This method creates recipe with given request body
	 *
	 * @param recipe the recipe request
	 * @return the response entity
	 */
	@PostMapping("/create")
	ResponseEntity<Void> createRecipe(@RequestBody Recipe recipe);

	/**
	 * This method updates recipe of given id with the information provided in
	 * request body
	 *
	 * @param recipe the recipe request
	 * @param id            the id
	 * @return the response entity
	 */
	@PutMapping("/update/{id}")
	ResponseEntity<Void> updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id);

	/**
	 * This method deletes recipe by given ID
	 *
	 * @param id the id
	 */
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteRecipe(@PathVariable Long id);
}
