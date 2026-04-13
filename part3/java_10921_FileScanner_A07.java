import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10921_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File instance for the directory you want to scan.
        File directory = new File("C:\\path\\to\\directory");

        // Use a FileFilter to only accept directories.
        File[] directoryFiles = directory.listFiles(file -> file.isDirectory());

        // If no directories, print a message and exit.
        if (directoryFiles == null) {
            System.out.println("No directories found in the given path.");
            return;
        }

        // Scan all files in the directory.
        for (File file : directoryFiles) {
            scanFile(file);
        }
    }

    private static void scanFile(File file) {
        // Create a Scanner for the file.
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // In a security-sensitive operation, you might check if the line contains
                // a specific string or pattern, for example, a password.
                if (line.contains("password")) {
                    System.out.println("Password found in file: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}