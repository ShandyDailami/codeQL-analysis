import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_05677_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File directory = new File(".");
        scanner.findFiles(directory, new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
    }
}

class FileScanner {
    public void findFiles(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    findFiles(file, filter);
                }
            }
        }
    }
}