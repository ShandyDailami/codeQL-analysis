import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_17029_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Obtain user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String path = scanner.next();

            // Step 2: Create FileScanner object
            FileScanner fileScanner = new FileScanner(path);

            // Step 3: Scan files in the directory
            File[] files = fileScanner.scanFiles();

            // Step 4: Print the files found
            System.out.println("Files in the directory: " + Arrays.toString(files));

            // Step 5: Close FileScanner
            fileScanner.close();

            // Step 6: Handle exceptions
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}