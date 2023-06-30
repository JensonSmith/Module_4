import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Conversion_Code {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        // Read from a file
        try {
            File inputFile = new File("C:\\Users\\jfunk\\OneDrive\\Desktop\\python\\Module 4\\Module_4\\input.txt");

            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Get user input for case conversion
        System.out.println("Choose the case conversion for the text:");
        System.out.println("1. Uppercase");
        System.out.println("2. Lowercase");
        System.out.println("3. No Conversion");
        System.out.print("Enter your choice: ");
        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();
        inputScanner.close();

        // Modify the data based on user choice
        for (int i = 0; i < lines.size(); i++) {
            String modifiedLine;
            switch (choice) {
                case 1:
                    modifiedLine = lines.get(i).toUpperCase();
                    break;
                case 2:
                    modifiedLine = lines.get(i).toLowerCase();
                    break;
                case 3:
                    modifiedLine = lines.get(i);
                    break;
                default:
                    System.out.println("Invalid choice. No conversion will be performed.");
                    modifiedLine = lines.get(i);
            }
            lines.set(i, modifiedLine);
        }

        // Write to a file
        try {
            File outputFile = new File("C:\\Users\\jfunk\\OneDrive\\Desktop\\python\\Module 4\\Module_4\\output.txt");
            FileWriter writer = new FileWriter(outputFile);

            for (String line : lines) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
