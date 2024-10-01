package com.pluralsight;

import java.util.Scanner;

/**
 * The SandwichShop Class provides a way to calculate the cost of sandwich
 * It implements the Scanner Object for user input
 * It has three methods; Main, promptForAge, promptForSandwichSize
  */
public class SandwichShop2 {


    // static Scanner object for user input
    final private static Scanner scanner = new Scanner(System.in);

    /**
     * get the base price of sandwich and discount based on their age and size of sandwich.
     * calculate their cost by multiply base price with discount.
     * @param args
     */
    public static void main(String[] args) {

        // input
        double sizeOfSandwich = promptForSandwichSize();
        double discount = promptForAge();
        double load = promptForAdditional(sizeOfSandwich);

        System.out.println("sizeOfSandwich: " + sizeOfSandwich);
        System.out.println("discount: " + discount);
        System.out.println("load: " + load);

        // processing
        double total = sizeOfSandwich * discount + load;

        //   output
        System.out.println("The total of the cost for sandwich: " + total);
    }

    /**
     *  ask for user whether they need additional loaded or not.
     * @param price
     * @return double
     */
    private static double promptForAdditional(double price) {
        System.out.println("would like the sandwich loaded (yes/no)  (Regular $ 1.00 | Large $ 1.75)");
        double additonalCost = 0;
        try {
            String option = scanner.nextLine();
            additonalCost = 0;

            if (price == 5.45) {
                additonalCost = option.toLowerCase().trim().equals("yes") ? 1.00 : 1.75;
            } else if (price == 8.95) {
                additonalCost = option.toLowerCase().trim().equals("no") ? 1.00 : 1.75;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  additonalCost;

    }

    /**
     * ask user's age
     * based on their age, determine the percentage of discount they will get.
     * @return double
     */
    private static double promptForAge() {
        System.out.println("How old are you?");
        int age = Integer.parseInt(scanner.nextLine().trim());
        double discount = 1.0;

        if (age >= 65) {
            discount = 0.8;  // 20% discount
            System.out.println("You get a 20% discount!");
        } else if (age <= 17) {
            discount = 0.9;  // 10% discount
            System.out.println("You get a 10% discount!");
        } else {
            System.out.println("You don't qualify for a discount.");
        }

        return discount;
    }

    /**
     *  get the user's option
     *  based on their option (regular or large) to determine the price of sandwich
     * @return double
     */
    private static double promptForSandwichSize() {
        double basePrice = 0;
        while (basePrice == 0) {
            System.out.println("Would you like a large or regular sandwich?");
            String option = scanner.nextLine().trim().toLowerCase();

            if (option.equals("large")) {
                basePrice = 8.95;
            } else if (option.equals("regular")) {
                basePrice = 5.45;
            } else {
                System.out.println("Invalid choice. Please select either 'large' or 'regular'.");
            }
        }

        return basePrice;
    }
}