import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_25196_FileScanner_A01 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(\\w+)$");

    private final String[] dirs;
    private final String[] exts;

    public java_25196_FileScanner_A01(String[] dirs, String[] exts) {
        this.dirs = dirs;
        this.exts = exts;
    }

    public void scan() {
        Arrays.stream(dirs).forEach(this::scanDirectory);
    }

    private void scanDirectory(String dir) {
        File directory = new File(dir);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + dir);
        }

        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && matchesExtension(pathname) && matchesDirectory(pathname));
            }

            private boolean matchesExtension(File pathname) {
                return Arrays.stream(exts).anyMatch(ext -> VALID_EXTENSIONS.matcher(pathname.getName()).matches());
            }

            private boolean matchesDirectory(File pathname) {
                return Arrays.stream(dirs).noneMatch(dir -> pathname.getAbsolutePath().startsWith(dir));
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(this::scanFile);
        }
    }

    private void scanFile(File file) {
        if (file.isFile()) {
            // Perform security sensitive operations here, for example, checking for Broken Access Control
        }
    }

    public static void main(String[] args) {
        String[] dirs = {".", ".."};
        String[] exts = {"txt", "log"};

        new SecureFileScanner(dirs, exts).scan();
    }
}