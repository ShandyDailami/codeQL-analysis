import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27688_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File("your_directory_here");

        // Create a new scanner to read files from the directory
        Scanner scanner = new Scanner(System.in);

        try {
            // Use recursive method to print all files in the directory and all its subdirectories
            printFiles(directory, "");
        } catch (FileNotFoundException e) {
            // Handle the security failure
            System.out.println("Failed to read the file: " + e.getMessage());
        } finally {
            // Close the scanner to free resources
            scanner.close();
        }
    }

    private static void printFiles(File directory, String indent) throws FileNotFoundException {
        // Print the directory name
        System.out.println(indent + directory.getName());

        // Get the list of files and directories in the directory
        File[] files = directory.listFiles();

        // If files is null, handle the case where there are no files in the directory
        if (files == null) return;

        // Iterate over the list of files and directories
        for (File file : files) {
            // If the file is a directory, call printFiles recursively to print the directory and its contents
            if (file.isDirectory()) {
                printFiles(file, indent + "  ");
            } else {
                // If the file is a file, print the file name
                System.out.println(indent + "  " + file.getName());
            }
        }
    }
}