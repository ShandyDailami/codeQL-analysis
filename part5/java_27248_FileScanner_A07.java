import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27248_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = System.getProperty("user.dir");
        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}