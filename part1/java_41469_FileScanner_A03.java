import java.io.File;
import java.util.Scanner;

public class java_41469_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\path\\to\\directory";

    public static void main(String[] args) {
        scanDirectory(DIRECTORY);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        scanDirectory(file.getPath());
                    }
                }
            }
        }
    }
}