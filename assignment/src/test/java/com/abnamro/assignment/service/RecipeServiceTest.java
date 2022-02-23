package com.abnamro.assignment.service;

import com.abnamro.assignment.assembler.RecipeAssembler;
import com.abnamro.assignment.entity.IngredientEntity;
import com.abnamro.assignment.entity.RecipeEntity;
import com.abnamro.assignment.model.Ingredient;
import com.abnamro.assignment.model.Recipe;
import com.abnamro.assignment.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RecipeServiceTest {

	@InjectMocks
	private RecipeService recipeService;

	@Mock
	private RecipeRepository recipeRepository;

	@Mock
	private RecipeAssembler recipeAssembler;

	@Test
	public void get_recipe() {

	}
}
