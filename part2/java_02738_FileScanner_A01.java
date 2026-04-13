import java.io.File;
import java.util.Scanner;

public class java_02738_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String directoryPath = scanner.nextLine();

        // Use the recursive method to scan all files in the directory
        scanFiles(new File(directoryPath));

        scanner.close();
    }

    private static void scanFiles(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                // Check if the file is a directory
                if (f.isDirectory()) {
                    // Recursively scan the directory
                    scanFiles(f);
                } else {
                    // Print the file name
                    System.out.println("File: " + f.getName());
                }
            }
        }
    }
}