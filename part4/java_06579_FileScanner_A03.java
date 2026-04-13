import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_06579_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.scanFiles("C:\\path\\to\\your\\directory");
    }
}

class FileScanner {
    void scanFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    scanFiles(file.getPath());
                }
            }
        }
    }

    void processFile(File file) {
        // Add your security-sensitive operations here.
        // For example, checking for SQL Injection and XSS attacks.
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Security-sensitive operation
                // e.g. check for SQL Injection:
                checkForSQLInjection(line);
                // or XSS:
                checkForXSSAttacks(line);
            }
            scanner.close();
        } catch (Exception e) {
            // Handle exception
        }
    }

    void checkForSQLInjection(String line) {
        // Implementation depends on your security framework.
        // This is a basic example.
        if (line.contains("DROP TABLE")) {
            System.out.println("SQL Injection detected in file " + file.getName());
        }
    }

    void checkForXSSAttacks(String line) {
        // Implementation depends on your security framework.
        // This is a basic example.
        if (line.contains("<script>")) {
            System.out.println("XSS attack detected in file " + file.getName());
        }
    }
}