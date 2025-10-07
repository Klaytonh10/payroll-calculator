package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainFileIO {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String input;

            // id | name | hours-worked | pay-rate
            while((input = bufferedReader.readLine()) != null) {
                String[] sections = input.split("\\|");
                Employee employee = new Employee(Integer.parseInt(sections[0]), sections[1], Double.parseDouble(sections[2]), Double.parseDouble(sections[3]));
                System.out.printf("Employee named %s made a measly $%.2f\n", employee.getName(), employee.calculateGrossPay());
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find the file: " + e);
        } catch (IOException e) {
            System.err.println("IO except issue");
        }
    }
}
