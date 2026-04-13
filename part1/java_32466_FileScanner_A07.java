import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32466_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Set up the directory to scan
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Scan the directory
        File[] files = directory.listFiles();

        // Check if the directory is empty
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory");
            return;
        }

        // Print out the filenames
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}