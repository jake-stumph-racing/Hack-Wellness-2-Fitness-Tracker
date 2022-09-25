package com.jakestumph;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {
        User jake = new User("Jake", 2500, 3);
        userList.add(jake);

        /*Check if user exists -- Ask via sys.in, if "yes" confirm w/ userList
        and allow to add meal info, if no account, call buildUser
         */

        Scanner mainScanner = new Scanner(System.in);
        System.out.println("Do you have a current user profile? Enter yes or no");
        String confirm1 = mainScanner.nextLine().toLowerCase();
        if(confirm1.equals("yes")){
            System.out.println("Enter user name");
            mainScanner.next();
            String confirmUser = mainScanner.nextLine().toLowerCase();
            if(findUser(confirmUser, userList)) {
                System.out.println("Account verified, welcome to the fitness tracker");
                return;
            } else {
                System.out.println("Account not found, try again.");
            }
        } else {
            System.out.println("First you have to build a user account");
            userList.add(buildUser());
//            System.out.println("Account created, welcome to the fitness tracker.");
        }
//        System.out.println("Account verified, welcome to the fitness tracker");
//        User jake = new User("Jake", 2500, 3);

//        Can't currently get account verification to work, but can build new account and start from there

        System.out.println("What would you like to do? (Pick a number)");
        System.out.println("(1) Input food\n(2) Check remaining calories for today" +
                "\n(3) Update account info\n(4) Quit the app");





        //Proteins
        Food chicken = new Food("Chicken Breast", 200, 4, true, false);

        Food leanBeef = new Food("Lean Beef", 250, 3,true, false);
        Food tuna = new Food("Tuna (canned)", 80, 3, true, false);
        Food salmon = new Food("Salmon", 250, 4, true, false);
        Food egg = new Food("Egg", 70, 1, true, true);
        Food quinoa = new Food("Quinoa", 220, 8, false, true);
        //Starches/carbs
        Food rice = new Food("Rice", 200, 8, false, true);
        Food pasta = new Food("Pasta", 300, 8, false, true);
        Food bread = new Food("Bread (1 slice)", 75, 1, false, true);
        //Veggies
        Food potato = new Food("Potatoes (whole)", 160, 1, false, true);
        Food saladMix = new Food("Salad mix (no dressing)", 30, 4, true, true);
        //Fruits
        Food banana = new Food("Bananas", 100, 1, false, true);
        Food strawberries = new Food("Strawberries", 50, 8, false, true);
        Food grapes = new Food("Grapes", 60, 8, false, true);
        Food apple = new Food("Apples", 100,1, false, true);
        Food blueberries = new Food("Blueberries", 80, 8, false, true);



//        updateDailyCalories(jake, chicken);


        //
        List<Food> ketoList = new ArrayList<Food>(); // if user selects keto, print list contents as reference
        ketoList.add(chicken); // position 0
        ketoList.add(leanBeef); // position 1
        ketoList.add(tuna); // position 2
        ketoList.add(salmon);
        ketoList.add(egg);
        ketoList.add(saladMix);

        List<Food> vegeList = new ArrayList<Food>(); // if user selects vege, print list contents as reference
        vegeList.add(quinoa); // position 0
        vegeList.add(rice); // etc. can call objects from list via position, too
        vegeList.add(pasta);
        vegeList.add(bread);
        vegeList.add(potato);
        vegeList.add(saladMix);
        vegeList.add(banana);
        vegeList.add(strawberries);
        vegeList.add(grapes);
        vegeList.add(apple);
        vegeList.add(blueberries);


    }

    public static User buildUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's build a new user profile! Please enter your user name:");
        String nameInput = scanner.nextLine();
        System.out.println("Okay " + nameInput + ", please enter your daily calorie goal:");
        Double calInput = scanner.nextDouble();
        System.out.println("Last thing for now: do you want to follow a specific kind of diet? (Pick a number)");
        System.out.println("(1) Keto-based\n(2) Vegetarian\n(3) Not really");
        int dietTypeInput = scanner.nextInt();

        User newUser = new User(nameInput, calInput, dietTypeInput);
        System.out.println("Cool, your profile looks like this: \n" + newUser +
                "\n You can always update things later if you would like. It's time to jump into the app.");

        return newUser;
    }

    public static boolean findUser(String name, List<User> users){
        for(User user : users){
            if(user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static boolean findUser(String userName){
        for(User user : userList){
            if(user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public static void updateDailyCalories(User user, Food food){
        double remainingCalories = user.dailyCalories - food.calories;
        System.out.println("Of your " + user.dailyCalories + " daily caloric intake, " +
                " you have " + remainingCalories + " calories left for today after eating " + food.getName());
    }
}
