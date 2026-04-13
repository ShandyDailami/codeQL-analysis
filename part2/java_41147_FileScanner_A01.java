import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41147_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFilesInDirectory(directory, "");
    }

    private static void printFilesInDirectory(File directory, String prefix) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, prefix + "/" + file.getName());
                } else {
                    System.out.println(prefix + "/" + file.getName());
                }
            }
        }
    }
}