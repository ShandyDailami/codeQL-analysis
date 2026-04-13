import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;

public class java_36967_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                String name = pathname.getName();
                return (name.endsWith(".txt") || name.endsWith(".exe"));
            }
        };

        printFiles(dir, fileFilter);
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