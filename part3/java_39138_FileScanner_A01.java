import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39138_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                printFilesInDirectory(file);
            }
        }
    }
}