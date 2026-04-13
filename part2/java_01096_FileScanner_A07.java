import java.io.File;
import java.util.Arrays;

public class java_01096_FileScanner_A07 {

    public static void main(String[] args) {
        // Define the starting directory
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Recursively print all files and directories in the directory
        printFilesAndDirectories(directory, "");
    }

    private static void printFilesAndDirectories(File directory, String indent) {
        // Print the directory
        System.out.println(indent + "Directory: " + directory.getPath());

        // Get all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            return; // No files
        }

        // Recursively print all files and directories
        for (File file : files) {
            if (file.isDirectory()) {
                // This file is a directory
                printFilesAndDirectories(file, indent + "  ");
            } else {
                // This file is a file
                System.out.println(indent + "  File: " + file.getPath());
            }
        }
    }
}