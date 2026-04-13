import java.io.File;
import java.util.Scanner;

public class java_07559_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // If the directory exists and is accessible
        if (directory.exists() && directory.canRead()) {
            // Get all files in the directory
            File[] files = directory.listFiles();

            // If there are files
            if (files != null) {
                for (File file : files) {
                    // If the file is a regular file
                    if (file.isFile()) {
                        // Print the file name
                        System.out.println("File: " + file.getName());
                    }
                    // If the file is a directory
                    else if (file.isDirectory()) {
                        // Print the directory name
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories in the specified directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not accessible.");
        }

        scanner.close();
    }
}