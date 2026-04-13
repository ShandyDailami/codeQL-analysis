import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19104_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object that represents the directory that the user wants to scan
        File directory = new File(".");

        // Use a FileFilter to only look at directories
        File[] directoryContents = directory.listFiles((dir, name) -> dir.isDirectory());

        // If directoryContents is null, there are no subdirectories
        if (directoryContents == null) {
            System.out.println("No directories found");
            return;
        }

        // Scan each subdirectory
        for (File subDirectory : directoryContents) {
            scanDirectory(subDirectory);
        }
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        // Make sure to only traverse the directory structure that the user wants to
        if (directory.getPath().contains("..")) {
            System.out.println("Directory traversal attempt detected");
            return;
        }

        // Get a list of all files in this directory
        File[] directoryContents = directory.listFiles();

        // If directoryContents is null, there are no files
        if (directoryContents == null) {
            System.out.println("No files found in " + directory.getPath());
            return;
        }

        // Scan each file
        for (File file : directoryContents) {
            // If the file is a directory, scan it
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                // If the file is a regular file, print its name
                System.out.println(file.getName());
            }
        }
    }
}