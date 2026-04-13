import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_03951_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        // Provide a directory path
        File directory = new File("C:\\path\\to\\your\\directory");

        // Traverse the directory
        traverseDirectory(directory);
    }

    public static void traverseDirectory(File directory) throws IOException {
        // Get all the files in the directory
        File[] files = directory.listFiles();

        // If the directory is not null
        if (files != null) {
            for (File file : files) {
                // If the file is a directory
                if (file.isDirectory()) {
                    // Traverse the directory
                    traverseDirectory(file);
                } else {
                    // Print the file name
                    System.out.println(file.getName());
                }
            }
        }
    }
}