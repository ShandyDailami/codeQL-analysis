import java.io.*;

public class java_27931_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("path_to_directory");
        scanDirectory(file);
    }

    public static void scanDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else if (file.isFile() && file.getName().endsWith(".txt")) {
                        // Add code here to handle .txt files
                    }
                }
            }
        }
    }
}