import java.io.File;
import java.util.Arrays;

public class java_10109_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDir = new File(".");

        // Recursively list all files in the current directory
        listFiles(rootDir, 0);
    }

    private static void listFiles(File dir, int indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Print a new directory
                    System.out.println(indentString(indent) + "Dir:   " + file.getName());
                    // Recursively list files in this directory
                    listFiles(file, indent + 2);
                } else {
                    // Print a file
                    System.out.println(indentString(indent) + "File: " + file.getName());
                }
            }
        }
    }

    // Utility to print indentation characters
    private static String indentString(int indent) {
        return repeatString("-", indent);
    }

    private static String repeatString(String str, int times) {
        return str.repeat(Math.max(0, times));
    }
}