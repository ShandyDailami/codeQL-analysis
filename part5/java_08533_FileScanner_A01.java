import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08533_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();

        // Use the scanner to navigate through the file system
        scanner.scan(".", ".*\\.java$");
    }

    // The FileScanner class
    private static class FileScanner {

        private void scan(String path, String pattern) {
            File file = new File(path);

            if (file.isDirectory()) {
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        scan(f.getPath(), pattern);
                    }
                }
            } else {
                if (file.getName().matches(pattern)) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();

                        // This is a placeholder for a security-sensitive operation.
                        // You should replace this with the actual code.
                        // e.g., check if a line contains a known vulnerability
                        if (line.contains("vulnerable")) {
                            System.out.println("Vulnerable line found: " + line);
                        }
                    }
                    scanner.close();
                }
            }
        }
    }
}