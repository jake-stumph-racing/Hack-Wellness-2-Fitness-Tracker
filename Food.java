package com.jakestumph;

public class Food {

    public String name;
    public double calories;
    public double servingSize; //ounces or units
    public boolean keto;
    public boolean vegetarian;

    public Food(String name, double calories, double servingSize, boolean keto, boolean vegetarian) {
        this.name = name;
        this.calories = calories;
        this.servingSize = servingSize;
        this.keto = keto;
        this.vegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories() {
        this.calories = calories;
    }

    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
        this.calories = calories / servingSize;
    }

    public boolean isKeto(){
        return keto;
    }

    public boolean isVegetarian(){
        return vegetarian;
    }

    public void nutritionInfo() {
        if(servingSize > 1) {
            System.out.println(this.getName() + " has " + this.calories +
                    " calories, and an average serving size of: " + this.getServingSize() + " ounces.");
        } else{
            System.out.println(this.getName() + " has " + this.calories +
                    " calories each.");
        }
    }
}
