import java.io.File;
import java.io.FileFilter;

public class java_06914_FileScanner_A07 {

    public static void main(String[] args) {
        File dir = new File("."); // Current directory
        printFiles(dir, new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
    }

    private static void printFiles(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}