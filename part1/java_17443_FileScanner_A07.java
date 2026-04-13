import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17443_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory"; // Replace with your directory path

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        scanDirectory(dir);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your security-sensitive operations here
                // For example, checking if line contains a password or login info
                if (containsPassword(line)) {
                    System.out.println("Found sensitive information in: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private static boolean containsPassword(String line) {
        // Replace this with your own password detection logic
        return line.contains("password") || line.contains("login") || line.contains("username") || line.contains("credentials");
    }
}