import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_31769_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File directory = new File(".");

        // Create a FileFilter object that only accepts .txt files
        FileFilter txtFiles = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use the scan method to find all .txt files in the directory
        File[] listFiles = directory.listFiles(txtFiles);
        if (listFiles != null) {
            for (File file : listFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files in directory");
        }
    }
}