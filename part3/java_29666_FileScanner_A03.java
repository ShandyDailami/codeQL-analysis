import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29666_FileScanner_A03 {
    private static final String DIR_PATH = "/path/to/directory"; // replace with your directory path
    private static final String EXTENSION = "txt"; // replace with your file extension

    public static void main(String[] args) {
        File directory = new File(DIR_PATH);

        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory);
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(EXTENSION)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}