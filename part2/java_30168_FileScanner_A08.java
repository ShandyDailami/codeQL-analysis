import java.io.File;
import java.util.Scanner;

public class java_30168_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file, 0);
    }

    private static void printFiles(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(file.getName());

        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isDirectory() && !f.getName().startsWith(".")) {
                    printFiles(f, depth + 1);
                }
            }
        }
    }
}