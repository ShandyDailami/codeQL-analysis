import java.io.File;
import java.util.Scanner;

public class java_38991_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            System.out.println("Scanning files in directory: " + directoryPath);
            scanFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }

    private static void scanFilesInDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                // Security-sensitive operations here. 
                // For example, checking if the file is readable and contains sensitive information.
                if (file.canRead() && containsSensitiveInformation(file)) {
                    System.out.println("Found file with sensitive information: " + file.getAbsolutePath());
                }
            } else if (file.isDirectory()) {
                scanFilesInDirectory(file);
            }
        }
    }

    // This method should be used for security-sensitive operations only. 
    // It is not recommended to use this method in a real-world scenario as it can lead to security risks.
    private static boolean containsSensitiveInformation(File file) {
        // Implement the logic to check for sensitive information in the file here.
        // This is a placeholder, it should be replaced with your actual implementation.
        return false;
    }
}