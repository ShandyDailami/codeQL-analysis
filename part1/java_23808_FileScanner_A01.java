import java.io.File;
import java.util.Scanner;

public class java_23808_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}