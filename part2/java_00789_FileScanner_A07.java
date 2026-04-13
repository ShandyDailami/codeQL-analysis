import java.io.File;
import java.util.Scanner;

public class java_00789_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFile(file);
                } else if (file.isDirectory()) {
                    checkDirectory(file);
                }
            }
        }
    }

    private static void checkFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("auth_failure")) {
                    System.out.println("Authentication failure detected in file: " + file.getName());
                    // Here you can implement your security-sensitive operations
                    // e.g., remove the file, block access, etc.
                    // ...
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    private static void checkDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFile(file);
                } else if (file.isDirectory()) {
                    checkDirectory(file);
                }
            }
        }
    }
}