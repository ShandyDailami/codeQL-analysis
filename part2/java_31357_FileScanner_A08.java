import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31357_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Prompt the user to enter the file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists and is readable
        if (file.exists() && file.canRead()) {
            // Use a FileScanner to read the file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Print the line to check if it is readable
                System.out.println(line);
            }
            fileScanner.close();
        } else {
            System.out.println("The file does not exist or is not readable.");
        }
        scanner.close();
    }
}