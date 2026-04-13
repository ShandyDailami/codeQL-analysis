import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06832_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // Replace with your directory
        scanDirectory(new File(directory));
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    public static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("---------------------------");
    }
}