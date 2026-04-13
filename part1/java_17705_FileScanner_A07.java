import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_17705_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        // Use the scanner to get the directory path from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a new File object for the directory
        File directory = new File(directoryPath);

        // Use the FileScanner API to list all the files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the full path of the file
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}