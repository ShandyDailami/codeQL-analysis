import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34543_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory";
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                printFilePath(file);
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    private static void printFilePath(File file) {
        System.out.println("File path: " + file.getPath());
    }
}