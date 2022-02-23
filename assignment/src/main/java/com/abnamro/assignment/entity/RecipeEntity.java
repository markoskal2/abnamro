package com.abnamro.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "create_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date createDate;

	@Column(name = "vegetarian")
	private boolean isVegetarian;

	@Column(name = "number_of_person")
	private int numberOfPerson;

	@Column(name = "instructions")
	private String instructions;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@Column(name = "ingredients")
	private List<IngredientEntity> ingredients;
}
