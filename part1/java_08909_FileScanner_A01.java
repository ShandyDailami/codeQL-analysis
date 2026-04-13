import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08909_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Get the current directory.
            File currentDir = new File(".");

            // Get all files in the current directory.
            File[] files = currentDir.listFiles();

            // Print the names of all files in the directory.
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}