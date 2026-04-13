import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_07298_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("Current directory: " + currentDir);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            System.exit(1);
        }

        Arrays.stream(files)
                .filter(file -> file.isFile())
                .forEach(file -> {
                    System.out.println("File: " + file.getName());
                    try {
                        // Security-sensitive operation related to A07_AuthFailure.
                        // Example: reading a file
                        System.out.println("Content: " + new String(java.nio.file.Files.readAllBytes(file.toPath())));
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                });
    }
}