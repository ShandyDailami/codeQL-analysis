import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34896_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("./src/main/java/A01_BrokenAccessControl");
        printFiles(file);
    }

    public static void printFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFiles(f);
                }
            }
        } else {
            try {
                System.out.println(file.getAbsolutePath());
            } catch (SecurityException e) {
                System.out.println("Access denied for file: " + file.getAbsolutePath());
            }
        }
    }
}