import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28348_FileScanner_A03 {

    // The main method
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File(".");

        // Scan the directory and its contents
        scanDirectory(directory);
    }

    // A method to recursively scan a directory and its contents
    private static void scanDirectory(File directory) {
        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if there are files
        if (files == null) {
            System.out.println("The directory is empty.");
            return;
        }

        // Scan each file
        for (File file : files) {
            // Check if the file is a directory
            if (file.isDirectory()) {
                // Recursively scan the directory
                scanDirectory(file);
            } else {
                // Scan the file for injection attacks
                scanFile(file);
            }
        }
    }

    // A method to scan a file for injection attacks
    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            // While there are more tokens to read, read and print them
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check if the line contains a command to execute
                if (line.contains("rm -rf")) {
                    System.out.println("Detected injection attack at " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + file.getAbsolutePath() + " was not found.");
        }
    }
}