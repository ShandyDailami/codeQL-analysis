import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21556_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (isFileInSecureRange(file)) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static boolean isFileInSecureRange(File file) {
        // Replace this with your own logic for checking file integrity
        // This is a simple example and may not work for all cases
        return file.length() > 0 && file.length() < 10000000; // for example
    }
}