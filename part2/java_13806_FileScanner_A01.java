import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13806_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/directory";  // replace with your directory path
        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    printDirectoryDetails(file);
                }
            }
        } else {
            System.out.println("Unable to list files!");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        // print other file details...
    }

    private static void printDirectoryDetails(File file) {
        System.out.println("Directory: " + file.getName());
        // print other directory details...
    }
}