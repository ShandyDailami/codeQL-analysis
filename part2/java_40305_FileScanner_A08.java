import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40305_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        listFiles(file, 0);
    }

    private static void listFiles(File file, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    listFiles(f, indentation + 1);
                }
            }
        }
    }
}