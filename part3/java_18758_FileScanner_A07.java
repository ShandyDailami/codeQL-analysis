import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18758_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        // Validate the directory path
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(0);
        }

        // Create a FileScanner for the directory
        File[] files = directory.listFiles();
        if (files != null) {
            // Filter out hidden files (e.g., .DS_Store on Mac)
            files = Arrays.stream(files)
                    .filter(file -> !file.getName().startsWith("."))
                    .toArray(size -> new File[size]);

            // Traverse the files and print their names
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Unable to list files in the directory");
        }

        // Close the scanner
        scanner.close();
    }
}