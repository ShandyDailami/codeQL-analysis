import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35245_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                        listFilesInDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }

    private static void listFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("   File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("   Directory: " + file.getAbsolutePath());
                    listFilesInDirectory(file);
                }
            }
        }
    }
}