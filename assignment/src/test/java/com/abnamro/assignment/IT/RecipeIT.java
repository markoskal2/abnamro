package com.abnamro.assignment.IT;

import com.abnamro.assignment.AssignmentApplication;
import com.abnamro.assignment.entity.IngredientEntity;
import com.abnamro.assignment.entity.RecipeEntity;
import com.abnamro.assignment.model.Ingredient;
import com.abnamro.assignment.model.Recipe;
import com.abnamro.assignment.repository.RecipeRepository;
import com.abnamro.assignment.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AssignmentApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("integrationTesting")
@DirtiesContext
public class RecipeIT {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	RecipeService recipeService;

	@MockBean
	RecipeRepository recipeRepository;

	@Autowired
	ObjectMapper mapper;

	@Test
	public void get_recipe_by_id() throws Exception {
		long id=1;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		Date date = Date.from(
				LocalDateTime.parse("21-02-2022 23:30", formatter)
						.atZone(ZoneId.systemDefault())
						.toInstant()
		);

		Ingredient ingredient = Ingredient.builder()
				.id(1)
				.name("tofu")
				.build();

		Ingredient ingredient2 = Ingredient.builder()
				.id(2)
				.name("fish")
				.build();

		var recipe = Recipe.builder()
				.id(1L)
				.name("test_name")
				.createDate(date)
				.isVegetarian(true)
				.numberOfPerson(2)
				.instructions("description")
				.ingredients(Arrays.asList(ingredient, ingredient2))
				.build();

		when(recipeService.getRecipe(id)).thenReturn(recipe);

		mockMvc.perform(get("/recipes/1")
				.with(user("user").password("password")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("id", is(recipe.getId().intValue())));
	}

	@Test
	public void create_recipe() throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		Date date = Date.from(
				LocalDateTime.parse("21-02-2022 23:30", formatter)
						.atZone(ZoneId.systemDefault())
						.toInstant()
		);

		Ingredient ingredient = Ingredient.builder()
				.id(1)
				.name("tofu")
				.build();

		Ingredient ingredient2 = Ingredient.builder()
				.id(2)
				.name("fish")
				.build();

		var recipe = Recipe.builder()
				.id(1L)
				.name("test_name")
				.createDate(date)
				.isVegetarian(true)
				.numberOfPerson(2)
				.instructions("description")
				.ingredients(Arrays.asList(ingredient, ingredient2))
				.build();

		RequestBuilder req= MockMvcRequestBuilders
				.post("/recipes/create")
				.with(user("user").password("password"))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(recipe));

		mockMvc.perform(req).andExpect(status().isCreated());
	}

	@Test
	public void get_all_recipes() throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		Date date = Date.from(
				LocalDateTime.parse("21-02-2022 23:30", formatter)
						.atZone(ZoneId.systemDefault())
						.toInstant()
		);

		Ingredient ingredient = Ingredient.builder()
				.id(1)
				.name("tofu")
				.build();

		Ingredient ingredient2 = Ingredient.builder()
				.id(2)
				.name("fish")
				.build();

		var recipe = Recipe.builder()
				.id(1L)
				.name("test_name")
				.createDate(date)
				.isVegetarian(true)
				.numberOfPerson(2)
				.instructions("description")
				.ingredients(Arrays.asList(ingredient, ingredient2))
				.build();
		List<Recipe> testOutput= Collections.singletonList(recipe);

		when(recipeService.getAllRecipes()).thenReturn(testOutput);

		mockMvc.perform(get("/recipes/all")
				.with(user("user").password("password")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(recipe.getId().intValue())));
	}

	@Test
	public void update_recipe() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		Date date = Date.from(
				LocalDateTime.parse("21-02-2022 23:30", formatter)
						.atZone(ZoneId.systemDefault())
						.toInstant()
		);

		Ingredient ingredient = Ingredient.builder()
				.id(1)
				.name("tofu")
				.build();

		Ingredient ingredient2 = Ingredient.builder()
				.id(2)
				.name("fish")
				.build();

		var recipe = Recipe.builder()
				.id(1L)
				.name("test_name")
				.createDate(date)
				.isVegetarian(true)
				.numberOfPerson(2)
				.instructions("description")
				.ingredients(Arrays.asList(ingredient, ingredient2))
				.build();

		RequestBuilder req= MockMvcRequestBuilders
				.put("/recipes/update/1")
				.with(user("user").password("password"))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(recipe));

		mockMvc.perform(req).andExpect(status().isOk());
	}
}
