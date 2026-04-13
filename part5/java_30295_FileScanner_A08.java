import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30295_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        printFiles(directory, 0);
    }

    private static void printFiles(File dir, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                printFiles(file, indent + 1);
            } else {
                printFile(file, indent + 1);
            }
        }
    }

    private static void printFile(File file, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
        System.out.println(file.getName());
    }
}