import java.io.File;
import java.util.Scanner;

public class java_13701_FileScanner_A08 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File dir = new File(currentDir);

        scanDirectory(dir);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check file integrity
                    if (checkFileIntegrity(file)) {
                        System.out.println("File: " + file.getAbsolutePath() + " is valid");
                    } else {
                        System.out.println("File: " + file.getAbsolutePath() + " is corrupted");
                    }
                } else if (file.isDirectory()) {
                    // Recurse into directory
                    scanDirectory(file);
                }
            }
        }
    }

    private static boolean checkFileIntegrity(File file) {
        // Your implementation of file integrity check here
        // For now, let's return true for simplicity
        return true;
    }
}