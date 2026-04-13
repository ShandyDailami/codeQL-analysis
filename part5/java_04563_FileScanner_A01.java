import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04563_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object representing the directory to be scanned
        File directory = new File("path/to/directory");

        // Use a FileFilter to only accept .txt files
        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Print out the list of text files
        for (File file : textFiles) {
            System.out.println(file.getPath());
        }

        // Ask the user if they want to search another directory
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to search another directory? (y/n): ");
        String response = scanner.next();

        // If the user says "y", recursively search the directory
        if (response.equalsIgnoreCase("y")) {
            System.out.println("Searching another directory...");
            Main.searchDirectory(new File("path/to/another/directory"));
        }
    }

    // This method will recursively search a directory for .txt files
    public static void searchDirectory(File directory) {
        File[] files = directory.listFiles();

        // If files is null, we've reached the end of the directory
        if (files == null) {
            return;
        }

        // Scan each file
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Found a .txt file: " + file.getPath());
            }
        }

        // If the directory is a directory, recursively search it
        if (files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file);
                }
            }
        }
    }
}