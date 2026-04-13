import java.io.File;
import java.util.Scanner;

public class java_30623_FileScanner_A01 {
    public static void main(String[] args) {
        File[] rootDirectoryFiles = File.listRoots();

        for (File file : rootDirectoryFiles) {
            printDirectoryInfo(file);
        }
    }

    public static void printDirectoryInfo(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printDirectoryInfo(file);
                }
            }
        }
    }

    public static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Size: " + file.length() + " bytes");
    }
}