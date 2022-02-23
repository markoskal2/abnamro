package com.abnamro.assignment.controller;

import com.abnamro.assignment.model.Recipe;
import com.abnamro.assignment.repository.RecipeRepository;
import com.abnamro.assignment.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RecipeControllerTest {

	@InjectMocks
	private RecipeController recipeController;

	@Mock
	private RecipeService recipeService;

	@Mock
	private RecipeRepository recipeRepository;

	@Test
	public void getRecipeById_200() {
		Long id = 1L;

		when(recipeService.getRecipe(id))
				.thenReturn(Recipe.builder().build());

		final var response = recipeController.getRecipe(id);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void createRecipe_200() {
		final var request = Recipe.builder().build();
		when(recipeService.createRecipe(request))
				.thenReturn(null);

		final var response = recipeController.createRecipe(request);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void updateRecipe_200() {
		Long id = 1L;
		final var request = Recipe.builder().build();

		when(recipeService.updateRecipe(request, id))
				.thenReturn(null);

		final var response = recipeController.updateRecipe(request, id);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
	}

}
