import java.io.File;
import java.util.Scanner;

public class java_01115_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory Scanning...");
                scanDirectory(file);
            } else {
                System.out.println("File Scanning...");
                scanFile(file);
            }
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void scanDirectory(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scanDirectory(f);
                } else {
                    scanFile(f);
                }
            }
        }
    }

    private static void scanFile(File file) {
        // Add security-sensitive operations here, e.g. checking file permissions
        // This is a basic example, it's not a complete solution
        System.out.println("Scanning file: " + file.getName());
    }
}