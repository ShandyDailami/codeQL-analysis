import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_33380_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File directory = new File("."); // current directory
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                System.out.println("File: " + file.getName());
                scanner.scanFile(file);
            });
        }
    }
}

class FileScanner {
    public void scanFile(File file) {
        // No security-sensitive operations here, only printing the file name
        System.out.println("Scanning file: " + file.getName());
    }
}