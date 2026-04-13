import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28912_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file, "");
    }

    private static void printFiles(File file, String prefix) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(prefix + f.getName());
                } else if (f.isDirectory()) {
                    printFiles(f, prefix + f.getName() + "/");
                }
            }
        }
    }
}