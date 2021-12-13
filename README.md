# COOKBOOK

## About The Project

Recipe database that stores two types of data:
* Recipe - preparation description and basic info (name, portions, prep time, preview image link)
* Ingredient - name, quantity and unit of necessary ingredient

Ingredients are in relation n:1 with recipe.

### Built With
* Java
* Spring
* Maven
* PostgreSQL
* JPA
* Deployed on Heroku


## Endpoints

### GET /recipes
Returns list of recipes

### GET /recipes/{id}
Return a recipe
###### PATH VARIABLES
Long id - primary key

### POST /recipes
Create recipe
######BODY
JSON of recipe

### PUT /recipes
Update recipe
######BODY
JSON of recipe

### DELETE /recipes/{id}
Delete specified recipe and assigned ingredients
###### PATH VARIABLES
Long id - primary key

### GET /recipes/{recipeId}/ingredients/{ingredientId}
Return one ingredient which is assigned to specified recipe
###### PATH VARIABLES
Long recipeId, Long ingredientId (primary keys)

### GET recipes/{recipeId}/ingredients
Return list of ingredients assigned to specified recipe
###### PATH VARIABLES
Long recipeId (primary key)

### POST /recipes/{recipeId}/ingredients
Create ingredient and assign it to recipe
###### PATH VARIABLES
Long recipeId (primary key)
######BODY
JSON of ingredient

### POST /recipes/{recipeId}/ingredients/list
Create all ingredient provided in list and assign them to recipe
###### PATH VARIABLES
Long recipeId (primary key)
######BODY
JSON of ingredient list

### PUT /recipes/{recipeId}/ingredients/{ingredientId}
Update ingredient
###### PATH VARIABLES
Long recipeId, Long ingredientId (primary keys)
######BODY
JSON of ingredient

### DELETE /recipes/{recipeId}/ingredients/{ingredientId}
Delete ingredient
###### PATH VARIABLES
Long recipeId, Long ingredientId (primary keys)

## Links:
* [Project GUI](https://arkodiusz.github.io/cookbook_ui/?#)
* [Project repo](https://github.com/Arkodiusz/cookbook)
* [My portfolio](https://arkodiusz.github.io)
