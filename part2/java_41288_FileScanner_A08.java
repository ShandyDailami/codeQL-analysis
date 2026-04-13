import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41288_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Ensure the directory exists and is accessible
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }

        // Use the FileScanner class to list all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Unable to list files in directory.");
        }
    }
}