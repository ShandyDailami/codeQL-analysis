import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18529_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory we want to scan
        File dir = new File(".");

        // Create a Scanner object for reading the directory contents
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a pattern to match
        System.out.println("Enter a pattern to match:");
        String pattern = scanner.nextLine();

        // Enumerate all files in the directory
        File[] files = dir.listFiles();

        // Check each file to see if it matches the pattern
        for (File file : files) {
            if (file.getName().matches(pattern)) {
                System.out.println("Found file: " + file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}