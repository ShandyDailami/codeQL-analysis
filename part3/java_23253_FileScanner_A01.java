import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_23253_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        printFiles(directory, (file) -> file.isFile() && file.getName().endsWith(".txt"));
    }

    public static void printFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files == null) return;
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                printFiles(file, filter);
            }
        }
    }
}