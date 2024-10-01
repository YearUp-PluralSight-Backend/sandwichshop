package com.pluralsight;

import java.util.Scanner;

/**
 * The SandwichShop Class provides a way to calculate the cost of a sandwich.
 * It implements the Scanner Object for user input.
 * It has three methods: main, promptForAge, and promptForSandwichSize.
 */
public class SandwichShop {

    final private static Scanner scanner = new Scanner(System.in);

    /**
     * Main method that calculates the cost of a sandwich based on size and age discount.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        double sizeOfSandwich = promptForSandwichSize();
        double discount = promptForAge();

        double total = discount == 0 ? sizeOfSandwich : sizeOfSandwich * discount;
        System.out.println("The total cost of the sandwich is: $" + total);
    }

    /**
     * Ask user's age and determine the percentage of discount based on their age.
     * @return double representing the discount multiplier (1.0 means no discount)
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
     * Get the user's option and determine the price of the sandwich based on the size.
     * @return double representing the base price of the sandwich
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
