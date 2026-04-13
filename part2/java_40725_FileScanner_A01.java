import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40725_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File file = new File(directoryPath);
        File[] hiddenFiles = file.listFiles(file -> file.isHidden());

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isDirectory()) {
                    printDirectoryContents(hiddenFile);
                } else {
                    System.out.println("File: " + hiddenFile.getAbsolutePath());
                }
            }
        }
    }

    private static void printDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}