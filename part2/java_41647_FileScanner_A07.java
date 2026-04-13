import java.io.File;
import java.util.Scanner;

public class java_41647_FileScanner_A07 {
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File(".");

        // Create a scanner to read files from the directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to scan:");
        String dirPath = scanner.nextLine();

        // Use the scanner to get the absolute path of the directory
        File dir = new File(dirPath);

        // Get all files in the directory
        File[] files = dir.listFiles();

        // Print all files
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}