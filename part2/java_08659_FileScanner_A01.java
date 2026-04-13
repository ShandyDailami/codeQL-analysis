import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_08659_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("/path/to/directory");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Return false to exclude directory entries
                return false;
            }
        };

        file.listFiles(filter);
    }
}