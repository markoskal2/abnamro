insert into RECIPE (cooking_instructions, create_date, vegetarian, name, number_of_person, id) values ('Prepare fried Samosa', '2020-10-23 23:30:05.26', true, 'Samosa', 2, 1);
insert into RECIPE (cooking_instructions, create_date, vegetarian, name, number_of_person, id) values ('Mixed Petti with differe sauce', '2020-10-23 23:30:05.26', true, 'Chat', 5, 2);
insert into RECIPE (cooking_instructions, create_date, vegetarian, name, number_of_person, id) values ('Chikan sabji with spices', '2020-10-23 23:30:05.26', false, 'Chikan Masala', 4, 3);
insert into RECIPE (cooking_instructions, create_date, vegetarian, name, number_of_person, id) values ('Boiled Milk with tea leaves and sugar', '2020-10-23 23:30:05.26', true, 'Tea', 4, 4);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Boiled Potatoes', 'Potato', 1);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Boiled Mutter', 'Mutter', 2);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('All purpose flour', 'Flour', 3);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('fried puri', 'Puri', 4);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Garlic Sauce', 'Garlic', 5);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Corriander Sauce', 'Corriander', 6);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Chikan', 'Chikan', 7);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('Milk', 'Milk', 8);
insert into INGREDIENT (ingredient_desciption, ingredient_name, id) values ('tea leaves', 'Tea', 9);
insert into recipe_ingredients (recipe_id, ingredients_id) values (1, 1);
insert into recipe_ingredients (recipe_id, ingredients_id) values (1, 2);
insert into recipe_ingredients (recipe_id, ingredients_id) values (1, 3);
insert into recipe_ingredients (recipe_id, ingredients_id) values (2, 4);
insert into recipe_ingredients (recipe_id, ingredients_id) values (2, 5);
insert into recipe_ingredients (recipe_id, ingredients_id) values (2, 6);
insert into recipe_ingredients (recipe_id, ingredients_id) values (3, 7);
insert into recipe_ingredients (recipe_id, ingredients_id) values (4, 8);
insert into recipe_ingredients (recipe_id, ingredients_id) values (4, 9);