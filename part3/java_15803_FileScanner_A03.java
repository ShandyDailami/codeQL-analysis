import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15803_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        try {
            File dir = new File(path);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isSecuritySensitive(file)) {
                        System.out.println("Found security sensitive file: " + file.getPath());
                    } else if (file.isDirectory()) {
                        System.out.println("Found directory: " + file.getPath());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static boolean isSecuritySensitive(File file) {
        // Implementation of the function that checks if a file is security sensitive
        // For this example, we'll assume if the file name ends with ".exe" or ".dll"
        return file.getName().endsWith(".exe") || file.getName().endsWith(".dll");
    }
}