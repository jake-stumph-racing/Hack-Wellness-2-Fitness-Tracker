package com.jakestumph;

public class User {
    String name;
//    double currentWeight;
//    double goalWeight;
    double dailyCalories;
    int dietType; // user picks from 1 - Keto, 2 - Veg, or 3 - NA

    public User(String name, double dailyCalories, int dietType) {
        this.name = name;
        this.dailyCalories = dailyCalories;
        this.dietType = dietType;
    }

    public String getName(String name) {
        return name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name; // if user wants to update name
    }

    public double getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(double dailyCalories) {
        this.dailyCalories = dailyCalories; // if user wants to update calorie target
    }

//    public void setRemainingCalories(){
//
//    }

    public void getRemainingCalories(){

    }

    public int getDietType() {
        return dietType;
    }

    public void setDietType(int dietType) {
        this.dietType = dietType; // if user wants to update diet type
    }

//    public void maintenanceCalories(){
//        implement calorie counter
//    }

    public void weightLossGoal(double currentWeight, double targetWeight){
        double difference = currentWeight - targetWeight; // weight in pounds
        double totalCals = difference * 3500; // 3500 kCal to a pound
        double duration = totalCals / 500; // duration in days to achieve goal
        System.out.println("Targeted weight loss is: " + difference + " pounds. It will take " +
                duration + " days if you subtract 500 calories from your daily allowance");
    }

    @Override
    public String toString() {
        return "User name: "+ name + "\nDaily Calorie Goal: " + dailyCalories + "\nDiet Type: " + dietType;
    }
}
