import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09502_FileScanner_A03 {
    public static void main(String[] args) {
        // Step 1: Get a directory path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Step 2: Create a File object with the directory path
        File directory = new File(directoryPath);

        // Step 3: Use a try-with-resources statement to automatically close the scanner and file
        try (Scanner fileScanner = new Scanner(directory)) {
            // Step 4: Use a while-loop to read each line in the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Step 5: Do something with the line (e.g., print it)
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Step 6: Handle the exception (e.g., print a message)
            System.out.println("The specified file does not exist.");
        }
    }
}