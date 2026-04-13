import java.io.File;
import java.util.Scanner;

public class java_40213_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.next();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("The directory does not exist.");
            System.exit(1);
        }

        // Get all the files in the directory
        File[] files = dir.listFiles();

        // Iterate over all files
        for (File file : files) {
            // Check if the file is a text file
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}