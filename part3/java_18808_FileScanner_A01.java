import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18808_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance for the directory we want to scan
        File directory = new File(".");

        // Scan the directory and all its subdirectories
        File[] foundFiles = directory.listFiles();

        // Print the names of the files
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}