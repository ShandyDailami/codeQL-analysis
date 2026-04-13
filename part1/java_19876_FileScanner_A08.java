import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class java_19876_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFilesInDirectory(file);
                }
            }
        }
    }
}