import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09141_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFiles(directory, "");
    }

    public static void printFiles(File directory, String indent) throws FileNotFoundException {
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
            }
        }

        File[] subdirectories = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subdirectories != null) {
            for (File directory : subdirectories) {
                printFiles(directory, indent + "  ");
            }
        }
    }
}