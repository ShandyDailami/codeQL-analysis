import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05343_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        listFiles(file, 0);
    }

    private static void listFiles(File file, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                listFiles(f, indent + 1);
            }
        }
    }
}