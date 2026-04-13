import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_10751_FileScanner_A07 {
    public static void main(String[] args) {
        File rootDirectory = new File("/path/to/your/directory");
        List<File> files = new ArrayList<>();

        // Use File's list method to find all files in a directory
        rootDirectory.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        // Use File's list method to find all directories in a directory
        rootDirectory.list(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        // Use FilenameFilter's list method to find files with a specific extension in a directory
        rootDirectory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("A07_AuthFailure");
            }
        });

        // Print all files that contain "A07_AuthFailure"
        for (File file : files) {
            System.out.println("File: " + file.getAbsolutePath());
        }
    }
}