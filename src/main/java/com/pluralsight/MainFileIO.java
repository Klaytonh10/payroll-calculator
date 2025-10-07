package com.pluralsight;

import java.util.Scanner;

public class MainFileIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Hours worked this week: ");
        String hoursWorked = scanner.nextLine();

        System.out.print("Pay rate: ");
        String payRate = scanner.nextLine();

        System.out.printf("Hello %s, your gross pay is $%.2f!", name, Double.parseDouble(hoursWorked) * Double.parseDouble(payRate));
    }
}
