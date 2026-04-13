import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_10114_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                if (pathname.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });
    }
}

class FileScanner {
    public void scanDirectory(String directoryPath, FileFilter fileFilter) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file.getPath(), fileFilter);
                } else {
                    System.out.println("Text file: " + file.getPath());
                }
            }
        }
    }
}