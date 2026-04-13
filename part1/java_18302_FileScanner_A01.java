import java.io.File;
import java.util.Scanner;

public class java_18302_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a new scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to search:");

        // Get file name from user
        String fileName = scanner.nextLine();

        // Get the current directory
        File currentDir = new File(".");

        // Search in the current directory
        searchInDirectory(currentDir, fileName);

        // Close the scanner
        scanner.close();
    }

    private static void searchInDirectory(File directory, String fileName) {
        // Get all files from the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    return;
                }
            }
        }

        System.out.println("File not found.");
    }
}