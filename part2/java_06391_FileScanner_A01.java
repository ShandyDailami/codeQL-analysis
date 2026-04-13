import java.io.File;
import java.util.Arrays;

public class java_06391_FileScanner_A01 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Get all files and directories in the current directory
        File[] files = currentDir.listFiles();

        // Check if any files were found
        if (files != null) {
            // Print all file names and directories
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found in the current directory.");
        }
    }
}