import java.io.File;
import java.util.Scanner;

public class java_07121_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a scanner to read the input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object to represent the directory
        File directory = new File(directoryPath);

        // Use the File.listFiles method to get an array of File objects
        File[] files = directory.listFiles();

        if (files != null) {
            // Loop through the array and print the file names
            for (File file : files) {
                System.out.println("File: " + file.getName());
            }
        } else {
            System.out.println("No files in directory!");
        }

        // Close the scanner
        scanner.close();
    }
}