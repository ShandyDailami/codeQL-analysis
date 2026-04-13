import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25692_FileScanner_A01 {

    // Create a file scanner object
    private Scanner scanner;

    // Create a file object
    private File file;

    // Initialize the file scanner object and file object
    public java_25692_FileScanner_A01(String filePath) {
        this.file = new File(filePath);
        this.scanner = new Scanner(file);
    }

    // Method to scan the file
    public void scanFile() {
        // While the scanner has more tokens
        while(this.scanner.hasNext()) {
            // Get the next token
            String token = this.scanner.next();

            // Check if the token is a directory
            if (this.isDirectory(token)) {
                // Get all files in the directory
                File[] directoryFiles = this.file.listFiles();

                // Check if there are files in the directory
                if (directoryFiles != null) {
                    // Scan all files in the directory
                    for (File directoryFile : directoryFiles) {
                        this.scanFile();
                    }
                }
            } else if (this.isFile(token)) {
                // Get the file name
                String fileName = this.file.getName();

                // Print the file name
                System.out.println("File name: " + fileName);

                // Print the file path
                System.out.println("File path: " + this.file.getAbsolutePath());

                // Print the file content
                System.out.println("File content: " + this.readFileContent());
            }
        }
    }

    // Method to check if a token is a file
    private boolean isFile(String token) {
        return new File(token).isFile();
    }

    // Method to check if a token is a directory
    private boolean isDirectory(String token) {
        return new File(token).isDirectory();
    }

    // Method to read the file content
    private String readFileContent() {
        // Initialize a string builder
        StringBuilder stringBuilder = new StringBuilder();

        // While the scanner has more tokens
        while(this.scanner.hasNext()) {
            // Get the next token
            String token = this.scanner.next();

            // Append the token to the string builder
            stringBuilder.append(token);
        }

        // Return the content of the file
        return stringBuilder.toString();
    }
}