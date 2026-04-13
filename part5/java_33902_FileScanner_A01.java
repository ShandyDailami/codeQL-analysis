import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33902_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory path
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Create a FileScanner
        File[] files = directory.listFiles();

        // Iterate over the files
        for (File file : files) {
            if (file.isFile()) {
                // Print out the file name
                System.out.println("File name: " + file.getName());
            }
        }

        // Close the scanner
        ((Scanner) files).close();
    }
}