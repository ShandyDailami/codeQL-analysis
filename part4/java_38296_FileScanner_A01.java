import java.io.File;
import java.util.Scanner;

public class java_38296_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("The directory does not exist.");
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
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canWrite());
        System.out.println("---------------------");
    }
}