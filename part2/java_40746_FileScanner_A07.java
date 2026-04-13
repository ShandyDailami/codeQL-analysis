import java.io.File;
import java.util.Scanner;

public class java_40746_FileScanner_A07 {

    public static void main(String[] args) {

        try {
            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the directory path:");

            // Get the directory path from user
            String directoryPath = scanner.nextLine();

            // Create a File object for the directory
            File directory = new File(directoryPath);

            // Check if the directory exists
            if (!directory.exists()) {
                System.out.println("Directory not found!");
                return;
            }

            // Get all the files in the directory
            File[] files = directory.listFiles();

            // Check if there are files in the directory
            if (files == null) {
                System.out.println("Directory is empty!");
                return;
           
            }

            // Print the names of all files in the directory
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ". " + files[i].getName());
            }

            // Close the scanner
            scanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}