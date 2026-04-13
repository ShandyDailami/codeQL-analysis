import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_10570_FileScanner_A07 {

    public static void main(String[] args) {
        File dir = new File(".");
        String[] files = dir.list();

        if (files != null) {
            for (String fileName : files) {
                File file = new File(fileName);

                // Check if file is a directory
                if (file.isDirectory()) {
                    // Recursive call for directory
                    scanDirectory(file);
                } else {
                    // Security-sensitive operation (A07_AuthFailure)
                    file.delete();
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call for directory
                    scanDirectory(file);
                } else {
                    // Security-sensitive operation (A07_AuthFailure)
                    file.delete();
                }
            }
        }
    }
}