import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13551_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            processFile(file);
                        }
                    } else if (file.isDirectory()) {
                        processDirectory(file);
                    }
                }
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    private static void processFile(File file) {
        // This is a placeholder for a real-world application.
        // For security sensitive operations, the actual implementation depends on the use case.
        // For example, a real-world application might need to check for specific permissions on the file and possibly read the content.
        System.out.println("Processing file: " + file.getAbsolutePath());
    }

    private static void processDirectory(File directory) {
        // This is a placeholder for a real-world application.
        // For security sensitive operations, the actual implementation depends on the use case.
        // For example, a real-world application might need to list all files in the directory and possibly recursively process the subdirectories.
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt")) {
                        processFile(file);
                    }
                } else if (file.isDirectory()) {
                    processDirectory(file);
                }
            }
        }
    }
}