import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00793_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/directory");
        printFiles(file, "");
    }

    private static void printFiles(File file, String path) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printFiles(f, path + f.getName() + "/");
                } else {
                    System.out.println(path + f.getName());
                }
            }
        }
    }
}