import java.io.File;
import java.util.Scanner;

public class java_20362_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("The directory does not exist!");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFilesInDirectory(file);
                }
            }
        }
    }
}