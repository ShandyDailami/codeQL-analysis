import java.io.File;
import java.util.Scanner;

public class java_01988_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] listFiles = dir.listFiles();

            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        listFilesInDirectory(file);
                    } else {
                        printFileDetails(file);
                    }
                }
            } else {
                System.out.println("Invalid directory path");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void listFilesInDirectory(File directory) {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    listFilesInDirectory(file);
                } else {
                    printFileDetails(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path relative to root: " + file.getPath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("-------------------------------");
    }
}