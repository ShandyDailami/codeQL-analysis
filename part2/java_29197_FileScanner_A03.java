import java.io.File;
import java.util.Scanner;

public class java_29197_FileScanner_A03 {
    private static String targetDirectory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        targetDirectory = scanner.nextLine();

        scanDirectory(new File(targetDirectory));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

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
        // Add your code here to scan the file for potential security vulnerabilities.
    }
}