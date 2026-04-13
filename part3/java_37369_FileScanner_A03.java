import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_37369_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan(".", ".*\\.txt$");
    }
}

class FileScanner {
    private File[] files;

    public java_37369_FileScanner_A03() {
        files = File.listRoots();
    }

    public void scan(String path, String pattern) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return Pattern.matches(pattern, pathname.getAbsolutePath());
            }
        };

        for (File file : files) {
            file.listFiles(filter);
        }
    }
}