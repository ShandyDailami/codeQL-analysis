import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11699_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFileNamesInDirectory(directory);
    }

    public static void printFileNamesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    printFileNamesInDirectory(file);
                }
            }
        }
    }

    public static void printFileName(File file) throws FileNotFoundException {
        if (file.canRead()) {
            System.out.println(file.getName());
        } else {
            System.out.println("Error: Can't read file " + file.getPath());
        }
    }
}