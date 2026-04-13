import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19988_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            listDirectoryContent(directory);
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    private static void listDirectoryContent(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listDirectoryContent(file);
                }
            }
        }
    }
}