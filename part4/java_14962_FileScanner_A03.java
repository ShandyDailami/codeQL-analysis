import java.io.File;
import java.util.Scanner;

public class java_14962_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the directory they want to scan
        System.out.print("Enter the directory to scan: ");
        String directoryPath = scanner.nextLine();

        // Create a File object and get its files
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // If there's no file or directory, print a message and exit
        if (files == null) {
            System.out.println("No files or directories found!");
            System.exit(0);
        }

        // Print all file and directory names
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}