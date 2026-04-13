import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_36228_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory to scan
        File directory = new File(".");

        // Create a list to hold the file names
        List<String> fileNames = new ArrayList<>();

        // Use a FileFilter to only include directories and match file names
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Iterate over the files
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }

        // Print out the file names and their sizes
        fileNames.forEach(fileName -> {
            System.out.println(fileName + " - " + fileName.length() + " bytes");
        });
    }
}