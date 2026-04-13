import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11344_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner object
        FileScanner scanner = new FileScanner();

        // Use the scanner object to scan a file
        scanner.scanFile("/path/to/file.txt");

        // Print the scanned file content
        System.out.println("Scanned file content: " + scanner.getScannedFileContent());
    }
}

class FileScanner {
    private String scannedFileContent;

    public void scanFile(String filePath) {
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                scannedFileContent += fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public String getScannedFileContent() {
        return scannedFileContent;
    }
}