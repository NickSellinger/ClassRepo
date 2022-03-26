package com.example.projectprototype;

public class Recipe {
    
    private Long recipeId;
    private String recipeName;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    
    public Recipe(){
        recipeName = "";
        ingredient1 = "";
        ingredient2 = "";
        ingredient3 = "";
        ingredient4 = "";
    }
    
    public Recipe(String recipeName, String ingredient1, String ingredient2,
                  String ingredient3, String ingredient4){
        this.recipeName = recipeName;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
    }
    
    public long getId(){ return recipeId;}
    public void setId(long recipeId){ this.recipeId = recipeId;}
    
    public String getName(){ return recipeName;}
    public void setName(String recipeName){ this.recipeName = recipeName;}

    public String getIngredient1(){ return ingredient1;}
    public void setIngredient1(String ingredient1){ this.ingredient1 = ingredient1;}

    public String getIngredient2(){ return ingredient2;}
    public void setIngredient2(String ingredient2){ this.ingredient2 = ingredient2;}

    public String getIngredient3(){ return ingredient3;}
    public void setIngredient3(String ingredient3){ this.ingredient3 = ingredient3;}

    public String getIngredient4(){ return ingredient4;}
    public void setIngredient4(String ingredient4){ this.ingredient4 = ingredient4;}
    
    
    
}
