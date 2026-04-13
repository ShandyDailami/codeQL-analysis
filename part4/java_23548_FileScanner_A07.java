import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23548_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner instance
        FileScanner scanner = new FileScanner();

        // Set the directory to scan
        File directory = new File("path_to_directory");

        // Set the file name to search for
        String fileName = "A07_AuthFailure.txt";

        // Start scanning
        scanner.scan(directory, fileName);
    }
}

class FileScanner {
    public void scan(File directory, String fileName) throws FileNotFoundException {
        // Get all the files in the directory
        File[] files = directory.listFiles();

        // If there are no files, exit the method
        if (files == null) {
            return;
        }

        // Iterate over all the files
        for (File file : files) {
            // If the file is a directory, recursively scan it
            if (file.isDirectory()) {
                scan(file, fileName);
            } else {
                // If the file is the one we're looking for, notify the user
                if (file.getName().equals(fileName)) {
                    System.out.println("AuthFailure file found in: " + file.getPath());
                }
            }
        }
    }
}