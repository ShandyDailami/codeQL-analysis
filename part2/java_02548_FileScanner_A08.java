import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02548_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    // Starts with 'java' and removes the comment
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here you can add your security-sensitive operations
                            // For example, check if a certain string is present in the file
                            if (line.contains("A08_IntegrityFailure")) {
                                System.out.println("Security Failure detected in: " + file.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
    }
}