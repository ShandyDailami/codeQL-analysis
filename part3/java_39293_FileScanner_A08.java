import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39293_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        long lastModified = directory.lastModified();

        while (true) {
            long current = directory.lastModified();
            if (current != lastModified) {
                lastModified = current;
                printFilesInDirectory(directory);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() >= lastModified - 5000) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}