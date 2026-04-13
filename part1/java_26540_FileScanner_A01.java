import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26540_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());
    }
}