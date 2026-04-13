import java.io.File;
import java.util.Scanner;

public class java_33509_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                    // This is a security-sensitive operation
                    // For demonstration purposes, we are only checking if the file
                    // name contains 'A01_BrokenAccessControl'
                    if (file.getName().contains("A01_BrokenAccessControl")) {
                        System.out.println("Broken Access Control violation detected in file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory name: " + file.getName());
                    // This is a security-sensitive operation
                    // For demonstration purposes, we are only checking if the directory
                    // name contains 'A01_BrokenAccessControl'
                    if (file.getName().contains("A01_BrokenAccessControl")) {
                        System.out.println("Broken Access Control violation detected in directory: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("No files or directories found in the specified directory.");
        }

        scanner.close();
    }
}