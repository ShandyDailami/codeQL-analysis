import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27448_FileScanner_A08 {

    private static String targetDirectory;

    public static void main(String[] args) {
        targetDirectory = "C:/testDir";  // replace with your directory
        scanDirectory(new File(targetDirectory));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile() && isFileSafe(file)) {
                    System.out.println("File found: " + file.getPath());
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // Add your security-related checks here
        // For now, we'll assume all files are safe
        return true;
    }
}