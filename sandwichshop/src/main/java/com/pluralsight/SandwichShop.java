package com.pluralsight;

import java.util.Scanner;

/**
 * The SandwichShop Class provides a way to calculate the cost of sandwich
 * It implements the Scanner Object for user input
 * It has three methods; Main, promptForAge, promptForSandwichSize
 */
public class SandwichShop {


    final private static Scanner scanner = new Scanner(System.in);

    /**
     * get the base price of sandwich and discount based on their age and size of sandwich.
     * calculate their cost by multiply base price with discount.
     * @param args
     */
    public static void main(String[] args) {


        double sizeOfSandwich = promptForSandwichSize();
        double discount = promptForAge();

        double total = sizeOfSandwich * discount;
        System.out.println("The total of the cost for sandwich: " + total);
    }

    /**
     * ask user's age
     * based on their age, determine the percentage of discount they will get.
     * @return double
     */
    private static double promptForAge() {
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        double discount = 0;

        if (age >= 65) {
            discount = 0.8;
        } else if (age <= 17 && age > 0) {
            discount = 0.9;
        } else {
            System.out.println("Based on your age, you don't have any discount.");
        }

        return discount;

    }

    /**
     *  get the user's option
     *  based on their option (regular or large) to determine the price of sandwich
     * @return double
     */
    private static double promptForSandwichSize() {

        System.out.println("Would you like large size or regular size of sandwich?  ");
        String option = scanner.nextLine();
        double basePrice = 0;

        if (option.toLowerCase().trim().equals("large")) {
            basePrice = 5.45;
        } else if (option.toLowerCase().trim().equals("regular")) {
            basePrice = 8.95;
        } else {
            System.out.println("Please choose the either large or regular.");
        }

        return basePrice;
    }
}
