import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31930_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        scanDirectory(directory, "");
    }

    private static void scanDirectory(File directory, String indentation) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indentation + "Directory: " + file.getName());
                    scanDirectory(file, indentation + "    ");
                } else if (file.isFile()) {
                    System.out.println(indentation + "File: " + file.getName());
                }
            }
        }
    }
}