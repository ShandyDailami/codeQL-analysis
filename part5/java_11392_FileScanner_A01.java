import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_11392_FileScanner_A01 {

    public static void main(String[] args) {
        File dir = new File(".");
        printFiles(dir, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".java");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
            }
        }

        File[] subDirs = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subDirs != null) {
            for (File subDir : subDirs) {
                printFiles(subDir, indent + "  ");
            }
        }
    }
}