import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_26560_FileScanner_A08 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        scanner.scan();
    }
}

class FileScanner {
    private String directory;

    public java_26560_FileScanner_A08(String directory) {
        this.directory = directory;
    }

    public void scan() {
        File dir = new File(directory);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}