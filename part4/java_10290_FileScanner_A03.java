import java.io.File;
import java.util.Scanner;

public class java_10290_FileScanner_A03 {

    public static void main(String[] args) {

        // Prompt the user for a directory
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory: ");
        String directoryPath = scanner.next();

        // Create a File object representing the directory
        File directory = new File(directoryPath);

        // Scan the directory
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {

        // Get all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {

                // Check if the file is a directory
                if (file.isDirectory()) {

                    // Recursively scan the directory
                    scanDirectory(file);

                } else {

                    // Print the file name
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}