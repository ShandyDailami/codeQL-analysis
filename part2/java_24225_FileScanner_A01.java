import java.io.File;
import java.util.Scanner;

public class java_24225_FileScanner_A01 {
    private static final String SECURITY_VIOLATION_WARNING = "Warning: Security violation!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileScanner(directory);
        } else {
            System.out.println("Invalid directory or path provided.");
        }
    }

    private static void fileScanner(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    handleFile(file);
                } else if (file.isDirectory()) {
                    fileScanner(file);
                }
            }
        }
    }

    private static void handleFile(File file) {
        try {
            if (file.canRead()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // This is a security sensitive operation.
                    // Remove it if it's not necessary.
                    if (line.contains("password")) {
                        System.out.println(SECURITY_VIOLATION_WARNING);
                    }
                }
                scanner.close();
            } else {
                System.out.println("Cannot read file: " + file.getPath());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + file.getPath());
        }
    }
}