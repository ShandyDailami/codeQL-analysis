import java.io.File;
import java.util.Scanner;

public class java_32098_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            scannerDirectory(directory);
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void scannerDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scannerDirectory(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("-----------------------");
    }
}