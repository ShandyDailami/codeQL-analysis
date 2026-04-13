import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

public class java_09015_FileScanner_A08 {
    public static void main(String[] args) {
        HashSet<String> uniqueFiles = new HashSet<String>();

        // Start the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the directory path:");
            String dirPath = scanner.nextLine();

            File dir = new File(dirPath);

            if (dir.exists() && dir.isDirectory()) {
                findUniqueFiles(dir, uniqueFiles);
            } else {
                System.out.println("Invalid directory path.");
            }
        }

        // Print unique files
        for (String file : uniqueFiles) {
            System.out.println(file);
        }
    }

    private static void findUniqueFiles(File dir, HashSet<String> uniqueFiles) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    uniqueFiles.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findUniqueFiles(file, uniqueFiles);
                }
            }
        }
    }
}