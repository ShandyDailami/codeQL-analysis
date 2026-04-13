import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37410_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list();

        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                File fileEntry = new File(file);
                if (fileEntry.isFile()) {
                    printFileInfo(fileEntry);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.printf("Name: %s%n", file.getName());
        System.out.printf("Path: %s%n", file.getAbsolutePath());
        System.out.printf("Absolute path: %s%n", file.getPath());
        System.out.printf("Is directory: %s%n", file.isDirectory() ? "Yes" : "No");
        System.out.printf("Is file: %s%n", file.isFile() ? "Yes" : "No");
        System.out.printf("Last modified: %s%n", file.lastModified() + "");
        System.out.println("--------------");
    }
}