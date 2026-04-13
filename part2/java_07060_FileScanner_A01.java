import java.io.File;
import java.util.Scanner;

public class java_07060_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\your_directory_path"; // replace with your directory path

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // handle file here
                } else if (file.isDirectory()) {
                    // handle directory here
                }
            }
        }
    }
}