import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41868_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // This is a simple example of a security-sensitive operation
                        // We're assuming that the file contains some content
                        // and it's trying to execute a command via System.exec()
                        // This is a bad practice for security reasons.
                        System.exec("cat " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        // Again, this is a security-sensitive operation.
                        // We're assuming that the directory contains some content
                        // and it's trying to execute a command via System.exec()
                        System.exec("ls " + file.getAbsolutePath());
                    }
                });
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}