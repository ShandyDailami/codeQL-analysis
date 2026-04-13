import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06612_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        printFilesInDirectory(file);
    }

    private static void printFilesInDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println(file.getName());
    }
}