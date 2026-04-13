import java.io.*;

public class java_17148_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // specify your directory path
        printLargeFiles(dirPath);
    }

    private static void printLargeFiles(String dirPath) {
        File file = new File(dirPath);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.length() > 500) {
                    System.out.println(f.getName());
                } else if (f.isDirectory()) {
                    printLargeFiles(f.getPath());
                }
            }
        }
    }
}