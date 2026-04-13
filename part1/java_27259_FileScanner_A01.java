import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_27259_FileScanner_A01 {
    private final File rootDir;
    private final Pattern filePattern;

    public java_27259_FileScanner_A01(File rootDir, String filePattern) {
        this.rootDir = rootDir;
        this.filePattern = Pattern.compile(filePattern);
    }

    public void scan() {
        File[] files = rootDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return filePattern.matcher(pathname.getName()).matches();
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        File rootDir = new File("/path/to/directory");
        SecureFileScanner scanner = new SecureFileScanner(rootDir, ".*\\.txt$");
        scanner.scan();
    }
}