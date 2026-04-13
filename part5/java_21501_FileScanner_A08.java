import java.io.File;
import java.util.Scanner;

public class java_21501_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "."; // replace with the directory you want to scan
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Error: " + directoryPath + " does not exist.");
            }
        } else {
            System.out.println("Error: " + directoryPath + " does not exist.");
        }
    }
}