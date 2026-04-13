import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39586_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File root = new File(".");
        searchFiles(root);
    }

    private static void searchFiles(File file) throws FileNotFoundException {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    searchFiles(f);
                } else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}