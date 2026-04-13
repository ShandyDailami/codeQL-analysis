import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_11956_FileScanner_A03 {
    private final File directory;

    public java_11956_FileScanner_A03(File directory) {
        this.directory = directory;
    }

    public void listFilesRecursively() {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(".*\\.(txt|java)$"); // accepts .txt and .java files
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> listFilesRecursively(file));
        }

        File[] dirs = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (dirs != null) {
            Arrays.stream(dirs).forEach(dir -> listFilesRecursively(dir));
        }
    }

    public static void main(String[] args) {
        File directory = new File("path/to/directory"); // replace with your directory path
        new MinimalistFileScanner(directory).listFilesRecursively();
    }
}