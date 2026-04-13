import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10507_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    System.out.println("Folder: " + file.getName());
                    listFilesInFolder(file);
                }
            }
        } else {
            System.out.println("No files found in the directory or a parent directory is not a directory.");
        }
    }

    private static void listFilesInFolder(File folder) throws FileNotFoundException {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("  File: " + file.getName());
                } else {
                    System.out.println("  Folder: " + file.getName());
                    listFilesInFolder(file);
                }
            }
        }
    }
}