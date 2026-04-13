import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01880_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";
        File directory = new File(directoryPath);
        scanFiles(directory);
    }

    private static void scanFiles(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("Found text file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    scanFiles(file);
                }
            }
        }
    }
}