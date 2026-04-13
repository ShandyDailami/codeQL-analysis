import java.io.File;
import java.io.FileFilter;

public class java_10885_FileScanner_A03 {
    private File root;

    public java_10885_FileScanner_A03(String rootPath) {
        this.root = new File(rootPath);
    }

    public void scan(final FileFilter filter) {
        scan(root, filter);
    }

    private void scan(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file, filter);
                } else {
                    process(file);
                }
            }
        }
    }

    private void process(File file) {
        // Implement the security-sensitive operation here
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/root");
        scanner.scan(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Implement the file filter here
                return true;
            }
        });
    }
}