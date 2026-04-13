import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38820_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Using the FileScanner to scan directories and files.
            FileScanner scanner = new FileScanner();

            // Prompt for a directory to scan.
            System.out.print("Enter a directory to scan: ");
            Scanner input = new Scanner(System.in);
            String directoryPath = input.nextLine();
            File directory = new File(directoryPath);

            // Ensure the directory exists and is readable.
            if (!directory.exists() || !directory.canRead()) {
                System.out.println("Invalid directory or insufficient permissions.");
                return;
            }

            // Scan the directory and its subdirectories.
            scanner.scan(directory);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // FileScanner class.
    private static class FileScanner {
        public void scan(File file) throws FileNotFoundException {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    scan(child);
                }
            } else {
                if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {
                    System.out.println("Suspicious file found: " + file.getPath());
                }
            }
        }
    }
}