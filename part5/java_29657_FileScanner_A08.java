import java.io.File;
import java.util.Arrays;

public class java_29657_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the current directory
        File currentDir = new File(".");

        // List all files and directories in the current directory
        File[] listOfFiles = currentDir.listFiles();

        // Check if listOfFiles is null
        if (listOfFiles == null) {
            System.out.println("There are no files in this directory.");
            return;
        }

        // Iterate over listOfFiles
        for (File file : listOfFiles) {
            // Check if file is a directory
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            } else { // if it's a file
                System.out.println("File: " + file.getName());
            }
        }
    }
}