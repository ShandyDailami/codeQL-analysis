import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15981_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a new File object
        File file = new File(directoryPath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file is a directory
        if (!file.isDirectory()) {
            System.out.println("Input is not a directory!");
            return;
        }

        try {
            // Use a FileScanner to scan the directory for files
            FileScanner fileScanner = new FileScanner(file, true);

            // Scan the directory for files
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.next();
                System.out.println("File Path: " + filePath);

                // Check if the file has executable permission
                if (!file.canExecute()) {
                    System.out.println("File " + filePath + " has not execute permission!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}