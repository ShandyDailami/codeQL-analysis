import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_34295_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    processDirectory(file);
                }
            }
        }

        scanner.close();
    }

    private static void processDirectory(File directory) {
        // No action needed in this scenario
        System.out.println("Processing directory: " + directory.getAbsolutePath());
    }

    private static void processFile(File file) {
        try {
            if (file.getName().endsWith(".txt")) {
                System.out.println("Processing file: " + file.getAbsolutePath());
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Modify the line here to break the security-sensitive operation
                    // For example:
                    // if (line.contains("admin")) {
                    //     System.out.println("Detected suspicious line: " + line);
                    // }
                    // Remove the comment above to break the security-sensitive operation
                }
                scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getAbsolutePath());
        }
    }
}