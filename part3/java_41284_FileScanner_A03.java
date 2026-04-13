import java.io.File;
import java.util.Arrays;

public class java_41284_FileScanner_A03 {
    public static void main(String[] args) {
        // Directory to start scanning from
        File directory = new File(".");

        // List all files in the current directory
        File[] files = directory.listFiles();

        // Check if there are files
        if (files != null) {
            for (File file : files) {
                // Check if file is a regular file and not a directory
                if (file.isFile() && !file.isDirectory()) {
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}