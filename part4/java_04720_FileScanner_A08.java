import java.io.File;
import java.util.Scanner;

public class java_04720_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // Use the current directory.
        countFiles(directory);
    }

    public static void countFiles(File directory) {
        int count = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    count++;
                }
            }
        }
        System.out.println("Number of files: " + count);
    }
}