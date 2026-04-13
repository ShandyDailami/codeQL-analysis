import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04075_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner
        FileScanner scanner = new FileScanner();

        // Use the scanner to scan a directory
        scanner.scanDirectory("path/to/directory");
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                // Create a Scanner for the file
                Scanner scanner = new Scanner(file);

                // Use the scanner to read the file
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Do something with the line (e.g., print it)
                    System.out.println(line);
                }

                // Close the Scanner
                scanner.close();
            }
        }
    }
}