import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_13005_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan(".", ".*\\.java$"); // scan from current directory
    }
}

class FileScanner {
    public void scan(String directory, String pattern) {
        File file = new File(directory);
        if (file.isDirectory()) {
            File[] list = file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().matches(pattern);
                }
            });
            if (list != null) {
                for (File file2 : list) {
                    System.out.println(file2.getAbsolutePath());
                }
            }
        }
    }
}