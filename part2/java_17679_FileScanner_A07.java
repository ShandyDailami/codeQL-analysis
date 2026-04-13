import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17679_FileScanner_A07 {
    public static void main(String[] args) {
        // Define the directory path and the file pattern to search for
        String directoryPath = "/path/to/directory";
        String filePattern = ".txt";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Create a File object for the directory's parent directory
        File parentDirectory = directory.getParentFile();

        // Scan files in the directory and its parent directory
        scanFiles(directory, filePattern);
        scanFiles(parentDirectory, filePattern);
    }

    public static void scanFiles(File directory, String filePattern) {
        // Get a list of all files in the directory
        File[] files = directory.listFiles();

        // If there are no files, return from the method
        if (files == null)
            return;

        // Iterate over the files
        for (File file : files) {
            // If the file is a directory, recursively scan its files
            if (file.isDirectory())
                scanFiles(file, filePattern);
            // If the file is a text file that matches the pattern
            else if (file.getName().matches(filePattern)) {
                // Print the file name
                System.out.println("File not in AuthFailure directory: " + file.getName());
            }
        }
    }
}