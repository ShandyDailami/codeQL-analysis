import java.io.File;
import java.util.Scanner;

public class java_05287_FileScanner_A01 {
    private String directory;

    public java_05287_FileScanner_A01(String directory) {
        this.directory = directory;
    }

    public void scanDirectory() {
        File root = new File(directory);
        Scanner scanner = new Scanner(System.in);

        // Start recursive method to scan directories
        recursiveScan(root, scanner);

        // Close the scanner
        scanner.close();
    }

    private void recursiveScan(File file, Scanner scanner) {
        if (file.isDirectory()) {
            System.out.println("Scanning directory: " + file.getAbsolutePath());

            // Read all files in the directory
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    recursiveScan(f, scanner);
                }
            }

            // Prompt for user input before proceeding
            System.out.println("Enter any key to continue or 'q' to quit:");
            String input = scanner.next();

            if (!input.equals("q")) {
                System.out.println("Continuing scan...");
                recursiveScan(file, scanner);
            } else {
                System.out.println("Quitting...");
            }
        } else {
            // Scan file for security-sensitive operations
            System.out.println("Scanning file: " + file.getAbsolutePath());
            // Add code here to scan file for security-sensitive operations
            // ...

            // Prompt for user input before proceeding
            System.out.println("Enter any key to continue or 'q' to quit:");
            String input = scanner.next();

            if (!input.equals("q")) {
                System.out.println("Continuing scan...");
                recursiveScan(file, scanner);
            } else {
                System.out.println("Quitting...");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory to scan:");
        String directory = scanner.next();
        SecureFileScanner scannerApp = new SecureFileScanner(directory);
        scannerApp.scanDirectory();
    }
}