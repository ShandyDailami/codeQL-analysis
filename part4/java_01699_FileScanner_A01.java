import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01699_FileScanner_A01 {
    public static void main(String[] args) {
        // Change the directory and extension as needed
        File dir = new File(".");
        String extension = ".txt";

        // List all files in directory
        System.out.println("Files in directory:");
        listFiles(dir);

        // List all files with specific extension
        System.out.println("\nFiles with extension " + extension + ":");
        listFilesWithExtension(dir, extension);
    }

    private static void listFiles(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }

    private static void listFilesWithExtension(File dir, String extension) {
        File[] files = dir.listFiles((d, name) -> name.endsWith(extension));
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}