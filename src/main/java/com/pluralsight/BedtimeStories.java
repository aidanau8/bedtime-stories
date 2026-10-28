package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of a story: ");
        String userInput = scanner.nextLine().trim();

        String fileName = "src/main/resources/" + userInput;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffReader = new BufferedReader(fileReader);

            int lineNumber = 1;
            String line = buffReader.readLine();

            while (line != null) {
                System.out.println(lineNumber + ". " + line);

                lineNumber++;
                line = buffReader.readLine();
            }

            buffReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + userInput);

        } catch (IOException e) {
            System.out.println("Problem reading the file: "
                    + e.getMessage());
        }
    }
}