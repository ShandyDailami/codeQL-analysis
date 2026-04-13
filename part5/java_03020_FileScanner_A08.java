import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03020_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory, 0);
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void printFilesInDirectory(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indentation + 1);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}