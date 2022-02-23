package com.abnamro.assignment.model;

import com.abnamro.assignment.entity.IngredientEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient {

	private long id;
	private String name;
	private String ingredientDescription;

	public static Ingredient toModel(IngredientEntity ingredient) {
		return Ingredient.builder()
				.id(ingredient.getId())
				.name(ingredient.getName())
				.ingredientDescription(ingredient.getIngredientDescription())
				.build();
	}
}
