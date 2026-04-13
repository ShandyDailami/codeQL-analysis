import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09331_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a FileScanner object that will scan files in the current directory
        FileScanner scanner = new FileScanner();

        // Define the file path
        String filePath = "./src/main/resources/";

        // Scan the directory
        scanner.scanDirectory(filePath);

        // Close the scanner
        scanner.close();
    }
}

class FileScanner {
    private File[] files;

    public void scanDirectory(String directoryPath) {
        // Get the directory
        File directory = new File(directoryPath);

        // Get all files in the directory
        files = directory.listFiles();

        // If there are no files, print a message
        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        // Print the file names
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public void close() {
        // Close the scanner
        files = null;
    }
}