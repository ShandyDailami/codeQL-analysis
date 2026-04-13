import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26634_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File currentDir = new File(".");
        printFilesInDirectory(currentDir);
    }

    public static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
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

    public static void printFileInfo(File file) throws FileNotFoundException {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
    }
}