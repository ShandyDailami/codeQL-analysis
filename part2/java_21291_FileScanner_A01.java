import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_21291_FileScanner_A01 {
    private final File rootDirectory;

    public java_21291_FileScanner_A01(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void scan(FileFilter filter) {
        File[] files = rootDirectory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                }
            }
        }
    }

    public void scan(String fileName, FileFilter filter) {
        File file = new File(rootDirectory, fileName);
        if (file.isFile() && file.canRead()) {
            System.out.println("Reading file: " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File("."));
        scanner.scan("*", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.canRead();
            }
        });
    }
}