import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13396_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner for reading the input file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a new file object for the directory
        File directory = new File(directoryPath);

        // If the directory does not exist or is not a directory, exit the program
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(0);
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // If no files, exit the program
        if (files == null) {
            System.out.println("No files in the directory");
            System.exit(0);
        }

        // Print all file names
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}