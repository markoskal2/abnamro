package com.abnamro.assignment.entity;

import com.abnamro.assignment.model.Ingredient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class IngredientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "ingredient_description")
	private String ingredientDescription;

	public static IngredientEntity toModelEntity(Ingredient ingredient) {
		return IngredientEntity.builder()
				.id(ingredient.getId())
				.name(ingredient.getName())
				.ingredientDescription(ingredient.getIngredientDescription())
				.build();
	}
}
