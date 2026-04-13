import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08441_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
        if (files == null) {
            System.out.println("No files found with extension: " + fileExtension);
        } else {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    try {
                        System.out.println("File: " + file.getPath());
                        // Removing comment for security-sensitive operations
                        // Example: Scanning for injection attacks
                        // if (file.getPath().contains("injection")) {
                        //     System.out.println("Detected injection attack in file: " + file.getPath());
                        // }
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                } else {
                    System.out.println("Directory: " + file.getPath());
                }
            });
        }
    }
}