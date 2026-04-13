import java.io.File;
import java.util.Scanner;

public class java_35780_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            scanFiles(directory);
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void scanFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanFiles(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        if (file.getName().endsWith(".txt")) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Perform security-sensitive operation here
                    // e.g. check for certain patterns in the file content
                    if (line.contains("auth")) {
                        System.out.println("Detected unauthorized access attempt in " + file.getPath());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error processing file " + file.getPath());
            }
        }
    }
}