import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16962_FileScanner_A03 {

    public static void main(String[] args) {
        File currentDir = new File(".");
        printFilesInDirectory(currentDir);
    }

    private static void printFilesInDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("-------------------------------");
    }
}