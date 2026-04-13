import java.io.File;
import java.util.Scanner;

public class java_30245_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a new Scanner for reading input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.print("Enter a directory: ");
        String directoryPath = scanner.nextLine();

        // Create a new File object for the directory
        File directory = new File(directoryPath);

        // List all the files in the directory
        File[] files = directory.listFiles();

        // Check if directory exists and print its contents
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        // Close the scanner
        scanner.close();
    }
}