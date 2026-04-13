import java.io.File;
import java.util.Scanner;

public class java_21040_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        File directory = new File(directoryPath);

        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files or directories found!");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                printFileDetails(file);
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Directory: " + file.getParent());
        System.out.println("Scanned: " + file.exists());
    }
}