import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18635_FileScanner_A01 {

    private static String directoryPath;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
            return;
        }
        directoryPath = args[0];
        scanDirectory(new File(directoryPath));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println(file.getPath());
    }
}