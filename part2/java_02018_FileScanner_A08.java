import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_02018_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] extensions = {"txt", "jpg", "png"};

        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(Arrays.asList(extensions).toString());
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with the specified extensions found!");
        }
    }
}