import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_27842_FileScanner_A03 {
    public static void main(String[] args) {
        // Define a directory
        File directory = new File(".");

        // Create a FileScanner
        File[] files = directory.listFiles();

        // If directory is not empty, sort it
        if (files != null) {
            Arrays.sort(files);

            // Print each file name
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}