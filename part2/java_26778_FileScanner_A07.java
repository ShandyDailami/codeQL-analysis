import java.io.File;
import java.util.Scanner;

public class java_26778_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the directory they want to scan
        System.out.println("Enter the directory you want to scan:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Create a File object for each file in the directory
        File[] files = directory.listFiles();

        // If files is null, then the directory is empty or the user does not have permission to access it
        if (files == null) {
            System.out.println("The directory is either empty or the user does not have permission to access it.");
        } else {
            // Print out each file name
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}