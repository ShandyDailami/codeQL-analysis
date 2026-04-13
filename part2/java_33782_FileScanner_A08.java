import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33782_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, false);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void listFiles(File directory, boolean printPath) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (printPath) {
                        System.out.println(file.getAbsolutePath());
                    } else {
                        System.out.println(file.getName());
                    }
                } else if (file.isDirectory()) {
                    if (printPath) {
                        System.out.println(file.getAbsolutePath());
                    } else {
                        System.out.println(file.getName());
                    }
                    listFiles(file, printPath);
                }
            }
        }
    }
}