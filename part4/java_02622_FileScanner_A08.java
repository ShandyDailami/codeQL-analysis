import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_02622_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner
        Scanner scanner = new Scanner(System.in);

        // Request user input for the file path
        System.out.println("Please enter the file path:");
        String filePath = scanner.nextLine();

        // Check if file exists at the given path
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Use a FileScanner to read the file
        FileScanner fileScanner = new FileScanner(file);

        // Check for integrity failures (implementation dependent)
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();

            // Replace sensitive data (implementation dependent)
            if (line.contains("password")) {
                line = line.replace("password", "********");
            }

            // Print the potentially modified line
            System.out.println(line);
        }

        // Close the FileScanner
        fileScanner.close();
    }
}