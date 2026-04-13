import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08121_FileScanner_A03 {
    public static void main(String[] args) {
        FileScannerExample scannerExample = new FileScannerExample();
        scannerExample.scanDirectory(".");
    }

    public void scanDirectory(String directory) {
        File rootDir = new File(directory);
        if (rootDir.exists() && rootDir.isDirectory()) {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // recursion for subdirectories
                        scanDirectory(file.getPath());
                    } else {
                        // print absolute path of file
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in directory: " + rootDir.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist: " + rootDir.getAbsolutePath());
        }
    }
}