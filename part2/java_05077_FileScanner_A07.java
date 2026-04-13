import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_05077_FileScanner_A07 {
    public static void main(String[] args) {
        String pattern = ".*A07_AuthFailure.*.java"; // replace with your own pattern
        FileScanner scanner = new FileScanner(pattern);
        scanner.scan(".");
    }
}

class FileScanner {
    private Pattern pattern;

    public java_05077_FileScanner_A07(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public void scan(String directory) {
        File root = new File(directory);
        File[] files = root.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file.getPath());
                } else {
                    if (pattern.matcher(file.getName()).matches()) {
                        System.out.println("Matched file: " + file.getPath());
                    }
                }
            }
        }
    }
}