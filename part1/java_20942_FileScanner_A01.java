import java.io.File;
import java.util.Scanner;

public class java_20942_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Enter a directory:");
        String directory = scanner.next();

        // Check if the provided directory exists
        File dir = new File(directory);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // List all files in the directory
        System.out.println("Files in directory:");
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}