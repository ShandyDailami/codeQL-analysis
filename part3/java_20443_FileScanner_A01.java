import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20443_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Use the current directory
        File currentDir = new File(".");

        // Use the recursive method to scan files and directories
        scanDirectory(currentDir);
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        // If there are no files or directories, return
        if (files == null) {
            return;
        }

        // Iterate over all files and directories
        for (File file : files) {
            if (file.isFile()) {
                // If the file is a regular file, print its name
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                // If the file is a directory, call the scanDirectory method recursively
                scanDirectory(file);
            }
        }
    }
}