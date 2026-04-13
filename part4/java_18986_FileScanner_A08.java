import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18986_FileScanner_A08 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
    }

    private static class FileScanner {

        private void scanDirectory(String directory, FileFilter filter) {
            File root = new File(directory);
            File[] files = root.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileDetails(file);
                    } else if (file.isDirectory()) {
                        scanDirectory(file.getPath(), filter);
                    }
                }
            }
        }

        private void printFileDetails(File file) {
            System.out.println("File Name : " + file.getName());
            System.out.println("Absolute path : " + file.getAbsolutePath());
            System.out.println("File Size : " + file.length() + " bytes");
            System.out.println("-------------------------------");
        }
    }
}