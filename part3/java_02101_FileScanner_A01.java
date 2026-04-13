import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02101_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        if (file.canRead()) {
            System.out.println("File: " + file.getPath());
        } else {
            System.out.println("Unable to read file: " + file.getPath());
        }
    }
}