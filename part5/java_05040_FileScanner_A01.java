import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05040_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        listFiles(file, 0);
    }

    private static void listFiles(File dir, int indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < indent; i++) {
                    System.out.print(" ");
                }
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                    listFiles(file, indent + 2);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }
}