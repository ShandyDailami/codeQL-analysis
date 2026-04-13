import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12162_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File root = new File(".");
        scanDirectory(root);
    }

    private static void scanDirectory(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call for directories
                    scanDirectory(file);
                } else {
                    // Print file name
                    System.out.println(file.getName());
                }
            }
        }
    }
}