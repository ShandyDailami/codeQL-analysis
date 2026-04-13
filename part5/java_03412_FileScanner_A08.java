import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_03412_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                printDirectoryContents(file);
            } else {
                System.out.println("The provided path does not point to a directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    printDirectoryContents(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
    }
}