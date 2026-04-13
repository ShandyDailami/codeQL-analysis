import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41685_FileScanner_A01 {

    public static void main(String[] args) {
        // Prompt for file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path:");
        String filePath = scanner.nextLine();

        try {
            // Scan file for sensitive operations
            Scanner fileScanner = new Scanner(new File(filePath));
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                // Sensitive operation here, like check password
                // If password is found, print error and end the program
                if (line.contains("password")) {
                    System.out.println("Error: password found in file!");
                    System.exit(0);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found!");
        }

        scanner.close();
    }
}