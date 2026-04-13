import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_17943_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File root = new File("."); // Use current directory
        printFiles(root, "txt");
    }

    private static void printFiles(File dir, String extension) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }

        File[] subDirs = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subDirs != null) {
            for (File subDir : subDirs) {
                printFiles(subDir, extension);
            }
        }
    }
}