import java.io.File;
import java.util.Scanner;

public class java_39280_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Enter a directory path:");
        String dirPath = scanner.nextLine();

        // Get the directory object
        File dir = new File(dirPath);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        // Scan the directory for files
        File[] files = dir.listFiles();

        // Print out the names of the files
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}