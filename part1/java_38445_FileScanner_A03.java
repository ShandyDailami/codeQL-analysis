import java.io.File;
import java.util.Scanner;

public class java_38445_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanFiles(directory);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void scanFiles(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                scanFile(file);
            } else if (file.isDirectory()) {
                scanFiles(file);
            }
        }
    }

    private static void scanFile(File file) {
        // Your security-sensitive operations here
        // For instance, you might scan for common passwords or other sensitive information
        // This is a simplistic example and does not include any security-sensitive operations

        System.out.println("Scanning file: " + file.getAbsolutePath());
    }
}