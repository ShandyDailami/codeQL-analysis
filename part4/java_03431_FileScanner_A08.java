import java.io.File;
import java.util.Scanner;

public class java_03431_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read the user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory name:");
        String dirName = scanner.nextLine();

        // Get the directory object
        File dir = new File(dirName);

        // Check if the directory exists
        if (dir.exists()) {
            // Get all the files in the directory
            File[] files = dir.listFiles();

            // Print all the file names
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        // Close the scanner
        scanner.close();
    }
}