import java.io.File;
import java.util.Arrays;

public class java_03652_FileScanner_A03 {

    public static void main(String[] args) {
        scanDirectory(".");
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Get all files and directories in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If the file is a directory, recursively scan it
                    scanDirectory(file.getAbsolutePath());
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}