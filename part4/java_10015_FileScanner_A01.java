import java.io.File;
import java.util.Scanner;

public class java_10015_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Parent: " + file.getParent());
        System.out.println("---------------------");
    }
}