import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_11032_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File instance
        File file = new File("src/main/resources/authFailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read lines from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check if the line contains a specific word
                if (line.contains("fail")) {
                    System.out.println("Failure detected: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}