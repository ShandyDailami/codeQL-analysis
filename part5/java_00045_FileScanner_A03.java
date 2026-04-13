import java.io.File;
import java.util.Scanner;

public class java_00045_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void scanFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFileForSecuritySensitiveOperations(file);
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }

    private static void scanFileForSecuritySensitiveOperations(File file) {
        // Add your security sensitive operations here
        // For example, you can print the file name:
        System.out.println("File name: " + file.getName());
    }
}