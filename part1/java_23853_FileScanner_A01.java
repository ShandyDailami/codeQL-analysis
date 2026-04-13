import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23853_FileScanner_A01 {

    // Method to read files from a directory
    public void readFilesFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Use a recursive approach to read all files and subdirectories
        readFilesRecursively(directory);
    }

    // Recursive function to read all files and subdirectories
    private void readFilesRecursively(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                // File is a text file
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operations here
                        // For example, check for a password in a line
                        if (line.contains("password")) {
                            System.out.println("Password detected in file: " + file.getName());
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                // Directory is a subdirectory
                readFilesRecursively(file);
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.readFilesFromDirectory("/path/to/directory");
    }
}