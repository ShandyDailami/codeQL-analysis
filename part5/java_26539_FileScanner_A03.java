import java.io.File;
import java.util.Scanner;

public class java_26539_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Create a Scanner to read input from the command line
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for the directory path
            System.out.println("Enter the directory path:");
            String dirPath = scanner.nextLine();

            // Create a FileScanner to scan files in a directory
            FileScanner fileScanner = new FileScanner(new File(dirPath));

            // Prompt the user for a file extension
            System.out.println("Enter a file extension:");
            String extension = scanner.nextLine();

            // Scan the directory for files with the specified extension
            fileScanner.scanFiles(extension);

            // Print the names of the files that were found
            fileScanner.getFileNames().forEach(System.out::println);

            // Close the scanner
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class FileScanner {
    private File dir;

    public java_26539_FileScanner_A03(File dir) {
        this.dir = dir;
    }

    public void scanFiles(String extension) {
        // Implementation of the scanFiles method
    }

    public void getFileNames(String extension) {
        // Implementation of the getFileNames method
    }

    public void close() {
        // Implementation of the close method
    }
}