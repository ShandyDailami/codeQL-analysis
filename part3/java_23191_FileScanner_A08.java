import java.io.File;
import java.util.Scanner;

public class java_23191_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        // Recursively search for files
        scanDirectory(file);
    }

    private static void scanDirectory(File directory) {
        File[] list = directory.listFiles();
        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isFile()) {
                // Print out the file name
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                // Recursively search in subdirectories
                scanDirectory(file);
            }
        }
    }
}