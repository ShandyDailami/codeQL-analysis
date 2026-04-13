import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00698_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the directory path:");
            String directoryPath = scanner.nextLine();

            if (directory.getPath().equals(directoryPath)) {
                System.out.println("\nList of files in the directory:");
                printFilesInDirectory(directory);
            } else {
                System.out.println("Invalid directory path. Program will exit.");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}