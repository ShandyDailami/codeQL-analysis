import java.io.File;
import java.util.Scanner;

public class java_41951_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File instance for the root directory
        File rootDir = new File(".");

        // Use recursion to traverse the directory structure
        traverseDirectory(rootDir);
    }

    private static void traverseDirectory(File dir) {
        // Get all the file names in the directory
        String[] files = dir.list();

        if (files != null) {
            for (String file : files) {
                // If the file is a directory, recursively traverse it
                if (new File(dir, file).isDirectory()) {
                    traverseDirectory(new File(dir, file));
                } else {
                    // If the file is a regular file, print its name
                    System.out.println(file);
                }
            }
        }
    }
}