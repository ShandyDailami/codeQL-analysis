import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_19572_FileScanner_A01 {

    private static final String ROOT_DIR = "C:/";

    public static void main(String[] args) throws FileNotFoundException {
        File root = new File(ROOT_DIR);
        fileSearch(root, "txt");
    }

    public static void fileSearch(File root, String extension) throws FileNotFoundException {
        File[] files = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                printFileInfo(file);
            }
        }

        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                fileSearch(file, extension);
            }
        }
    }

    private static void printFileInfo(File file) throws FileNotFoundException {
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        if (!file.canRead()) {
            System.out.println("Can't read file. Access is restricted!");
        }
        System.out.println("---");
    }
}