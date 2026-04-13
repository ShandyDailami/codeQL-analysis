import java.io.File;
import java.util.Scanner;

public class java_21018_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Get the directory object
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            // Get all files in the directory
            File[] files = dir.listFiles();

            // Print all files
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        // Close the scanner
        scanner.close();
    }
}