import java.io.File;
import java.util.Arrays;

public class java_20979_FileScanner_A03 {
    public static void main(String[] args) {
        // Specify the directory you want to scan
        File directory = new File(".");

        // List all the files in the directory
        File[] files = directory.listFiles();

        // Check if there are files
        if (files != null) {
            // Print the file names
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}