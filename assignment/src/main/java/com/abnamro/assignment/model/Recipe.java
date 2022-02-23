package com.abnamro.assignment.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
	private Long id;
	private String name;
	private Date createDate;
	private boolean isVegetarian;
	private int numberOfPerson;
	private String instructions;
	private List<Ingredient> ingredients;

}
