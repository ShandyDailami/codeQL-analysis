import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32727_FileScanner_A03 {
    public static void main(String[] args) {
        // Start file scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File dir = new File(directoryPath);

            // Start recursive file scan
            scanFiles(dir, "");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close scanner
            scanner.close();
        }
    }

    private static void scanFiles(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively call scanFiles for directories
                    scanFiles(file, indent + "  ");
                } else {
                    // Print file name
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}