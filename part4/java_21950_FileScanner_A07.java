import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21950_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory to scan
        File directory = new File(".");

        // Use a recursive method to scan all files in the directory
        scanDirectory(directory, "");
    }

    private static void scanDirectory(File directory, String indentation) throws FileNotFoundException {
        // Print out the indentation and the directory name
        System.out.println(indentation + directory.getName());

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Loop over all the files
        for (File file : files) {
            // If the file is a directory, recursively call the scanDirectory method
            if (file.isDirectory()) {
                scanDirectory(file, indentation + "  ");
            } else {
                // Print out the file name
                System.out.println(indentation + "  " + file.getName());
            }
        }
    }
}