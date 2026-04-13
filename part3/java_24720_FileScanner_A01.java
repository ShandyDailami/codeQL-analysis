import java.io.File;
import java.util.Scanner;

public class java_24720_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(path);
            if (file.exists()) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file);
                } else {
                    System.out.println("The path given does not exist or is not a directory.");
                }
            } else {
                System.out.println("The path given does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while accessing the directory: " + e.getMessage());
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}