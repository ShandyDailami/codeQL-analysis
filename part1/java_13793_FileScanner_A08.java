import java.io.File;
import java.util.Scanner;

public class java_13793_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a FileScanner to scan the current directory
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Check if the directory exists
        if (files == null) {
            System.out.println("Directory does not exist");
            return;
        }

        // Print the contents of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println("Content: " + fileScanner.nextLine());
                    }
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}