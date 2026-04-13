import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class java_34556_FileScanner_A07 {

    public static void main(String[] args) {

        // Initialize the scanner and the file
        Scanner scanner = new Scanner(System.in);
        File file = new File("example.txt");

        // Check if the file exists and can be read
        if (file.exists() && !file.isDirectory()) {
            try {
                // Open the file
                Scanner fileScanner = new Scanner(file);

                // Read the file line by line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
               
                }

                // Close the file scanner
                fileScanner.close();

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("File does not exist or is a directory.");
        }

        // Prompt the user for a new line of text
        System.out.println("Enter new text:");
        String newText = scanner.nextLine();

        // Append the new text to the file
        try {
            PrintWriter writer = new PrintWriter("example.txt");
            writer.println(newText);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}