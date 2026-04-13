import java.io.File;
import java.util.ArrayList;

public class java_09621_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("."); // Get the current directory
        printFilesInDirectory(directory);
    }

    public static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles(); // Get all the files in the directory

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) { // If it's a file
                    System.out.println(file.getName());
                } else if (file.isDirectory()) { // If it's a directory
                    printFilesInDirectory(file); // Recursively print the files in the directory
                }
            }
        }
    }
}