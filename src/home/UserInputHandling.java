package home;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputHandling {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String filePath = "user_input.txt";

            System.out.println("Enter some text to save to a file (type 'exit' to quit):");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                while (true) {
                    System.out.print("> ");
                    String userInput = scanner.nextLine();

                    // Exit if the user types "exit"
                    if (userInput.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting and saving to file...");
                        break;
                    }

                    // Write user input to file and add a newline
                    writer.write(userInput);
                    writer.newLine();
                }
                System.out.println("Data has been written to " + filePath);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }


}

