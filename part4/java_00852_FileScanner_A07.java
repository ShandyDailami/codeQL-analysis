import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00852_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner object for reading
        FileScanner scanner = new FileScanner();

        // Define the directory to scan
        File directory = new File("your/directory/path");

        // Scan the directory
        scanner.scanDirectory(directory);

        // Print the found files
        for (File file : directory.listFiles()) {
            System.out.println(file.getAbsolutePath());
        }

        // Close the FileScanner
        scanner.close();
    }
}

class FileScanner {
    private Scanner scanner;

    public java_00852_FileScanner_A07() {
        this.scanner = new Scanner(System.in);
    }

    public void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    authenticateFile(file);
                }
            }
        }
    }

    public void authenticateFile(File file) throws FileNotFoundException {
        // Authentication code goes here. For simplicity, this method does nothing
    }

    public void close() {
        this.scanner.close();
    }
}