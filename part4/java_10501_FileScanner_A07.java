import java.io.File;
import java.util.Scanner;

public class java_10501_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File directory = new File(path);

        if (directory.exists()) {
            scanFilesInDirectory(directory);
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    private static void scanFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    scanFilesInDirectory(file);
                }
            }
        }
    }
}