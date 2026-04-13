import java.io.File;
import java.util.Scanner;

public class java_29575_FileScanner_A01 {
    public static void main(String[] args) {
        // This should be your home directory
        String homeDir = System.getProperty("user.home");

        File homeDirFile = new File(homeDir);

        // Use recursiveFileSearch to find all files
        recursiveFileSearch(homeDirFile);
    }

    private static void recursiveFileSearch(File root) {
        File[] files = root.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Only print the name of the file
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    // Recursive call for subdirectories
                    recursiveFileSearch(file);
                }
            }
        }
    }
}