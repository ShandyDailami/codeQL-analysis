import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13103_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner
        FileScanner scanner = new FileScanner();

        // Specify the directory to scan
        File directory = new File("src/main/resources");

        // Scan the directory
        scanner.scanDirectory(directory);
    }
}

class FileScanner {

    public void scanDirectory(File directory) throws FileNotFoundException {
        // Recursively scan subdirectories
        File[] subDirectories = directory.listFiles();
        if (subDirectories != null) {
            for (File file : subDirectories) {
                scanDirectory(file);
            }
        }

        // Scan the directory itself
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileContent(file);
                }
            }
        }
    }

    private void printFileContent(File file) throws FileNotFoundException {
        // Print the file content
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}