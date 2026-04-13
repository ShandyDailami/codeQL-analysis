import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07183_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to scan for files in the current directory
        FileScanner scanner = new FileScanner();

        // Get the current directory and list all its files
        File[] files = scanner.listFiles(".");

        // Print out the list of files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

class FileScanner {
    public File[] listFiles(String pathname) throws FileNotFoundException {
        // This is a placeholder for the actual implementation. It will be replaced
        // with the actual implementation that handles security-related operations
        throw new UnsupportedOperationException();
    }
}