import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08960_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFilesInDirectory(directory, 0);
    }

    private static void printFilesInDirectory(File directory, int depth) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, depth + 1);
                } else {
                    printFileInfo(file, depth);
                }
            }
        }
    }

    private static void printFileInfo(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.printf("Name: %s, Size: %d bytes\n", file.getName(), file.length());
    }
}