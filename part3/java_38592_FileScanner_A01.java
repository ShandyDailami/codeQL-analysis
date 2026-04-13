import java.io.File;
import java.util.Scanner;

public class java_38592_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] hiddenFiles = directory.listFiles(file -> file.isHidden());
            if (hiddenFiles != null) {
                for (File hiddenFile : hiddenFiles) {
                    if (hiddenFile.isFile()) {
                        System.out.println("Found hidden file: " + hiddenFile.getName());
                        // This is a security-sensitive operation related to A01_BrokenAccessControl
                        // Imagine a file with sensitive information is extracted and stored in this file.
                        // This operation should be handled in a secure way.
                    }
                }
            } else {
                System.out.println("No hidden files in the directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}