package com.abnamro.assignment.assembler;

import com.abnamro.assignment.entity.IngredientEntity;
import com.abnamro.assignment.entity.RecipeEntity;
import com.abnamro.assignment.model.Ingredient;
import com.abnamro.assignment.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeAssembler {

	public Recipe assembleRecipe(final RecipeEntity recipeEntity) {
		if(recipeEntity == null)
			return null;

		return Recipe.builder()
				.id(recipeEntity.getId())
				.name(recipeEntity.getName())
				.createDate(recipeEntity.getCreateDate())
				.instructions(recipeEntity.getInstructions())
				.ingredients(recipeEntity.getIngredients().stream()
						.map(Ingredient::toModel)
						.collect(Collectors.toList())
				)
				.build();
	}

	public RecipeEntity toModel(final Recipe recipe) {
		return RecipeEntity.builder()
				.id(recipe.getId())
				.name(recipe.getName())
				.createDate(recipe.getCreateDate())
				.isVegetarian(recipe.isVegetarian())
				.numberOfPerson(recipe.getNumberOfPerson())
				.instructions(recipe.getInstructions())
				.ingredients(recipe.getIngredients().stream()
						.map(IngredientEntity::toModelEntity)
						.collect(Collectors.toList())
				)
				.build();
	}

}
