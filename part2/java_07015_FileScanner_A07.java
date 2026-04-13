import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07015_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner instance
        FileScanner scanner = new FileScanner();

        // Set the path of the directory to scan
        scanner.setDirectory("path/to/directory");

        // Scan the directory and print all the files
        scanner.scanDirectory();
    }

    // Define the FileScanner class
    private static class FileScanner {
        private String directoryPath;

        public void setDirectory(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public void scanDirectory() throws FileNotFoundException {
            File directory = new File(this.directoryPath);
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}