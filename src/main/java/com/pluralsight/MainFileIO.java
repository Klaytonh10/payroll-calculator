package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class MainFileIO {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of employee file to process: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/main/resources/" + fileName + ".json")) {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String input;

            // id | name | hours-worked | pay-rate
            while((input = bufferedReader.readLine()) != null) {
                String[] sections = input.split("\\|");
                int id = Integer.parseInt(sections[0]);
                String name = sections[1];
                double hoursWorked = Double.parseDouble(sections[2]);
                double payRate = Double.parseDouble(sections[3]);
                Employee employee = new Employee(Integer.parseInt(sections[0]), sections[1], Double.parseDouble(sections[2]), Double.parseDouble(sections[3]));
                System.out.printf("Employee named %s made a measly $%.2f\n", employee.getName(), employee.calculateGrossPay());
                writer.write("Employee named " + employee.getName() + " made a measly " + employee.calculateGrossPay() +"\n");
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find the file: " + e);
        } catch (IOException e) {
            System.err.println("IO except issue");
        }
    }
}
