import java.io.File;
import java.util.Scanner;

public class java_20343_FileScanner_A07 {

    // FileScanner is a utility class that simplifies file I/O operations
    private FileScanner fileScanner;

    public java_20343_FileScanner_A07(File file) {
        this.fileScanner = new FileScanner(file);
    }

    public void scanFile(String filePath) {
        this.fileScanner.open();

        // Use a Scanner to read each line in the file
        Scanner scanner = this.fileScanner.getScanner();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            // Perform some security-sensitive operation (e.g., verify if the line contains a specific secret)
            if (line.contains("secret")) {
                System.out.println("Detected suspicious activity in file: " + filePath);
            }
        }
        this.fileScanner.close();
    }

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        SecureFileScanner scanner = new SecureFileScanner(file);
        scanner.scanFile("file_path_to_scan");
    }
}