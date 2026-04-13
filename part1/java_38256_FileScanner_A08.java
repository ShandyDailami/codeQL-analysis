import java.io.File;
import java.util.Arrays;

public class java_38256_FileScanner_A08 {

    public static void main(String[] args) {
        File rootDir = new File("."); // This refers to the current directory
        searchForFile(rootDir, ".txt");
    }

    private static void searchForFile(File dir, String extension) {
        File[] files = dir.listFiles(); // Get a list of all files and directories in the directory

        // Check if files exists
        if (files == null) return;

        // Iterate over each file
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                // Recursively search inside this directory
                searchForFile(file, extension);
            }
        }
    }
}