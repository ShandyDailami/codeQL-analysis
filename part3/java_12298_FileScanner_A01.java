import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_12298_FileScanner_A01 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile(".*\\.(txt|doc|pdf|xlsx|png|jpg)$");

    public static void main(String[] args) {
        FileScanner(new File("."), new RegexFileFilter(".*"));
    }

    public static void FileScanner(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isValid(file)) {
                    System.out.println("Valid file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    FileScanner(file, filter);
                }
            }
        }
    }

    private static boolean isValid(File file) {
        return file.canRead() && !file.isHidden() && file.length() > 0 && VALID_EXTENSIONS.matcher(file.getName()).matches();
    }

    static class RegexFileFilter implements FileFilter {
        private final Pattern pattern;

        public java_12298_FileScanner_A01(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        @Override
        public boolean accept(File pathname) {
            return pattern.matcher(pathname.getName()).matches();
        }
    }
}