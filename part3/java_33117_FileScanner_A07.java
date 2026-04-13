import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

public class java_33117_FileScanner_A07 {

    public static void main(String[] args) {
        String rootDirectory = "/path/to/directory"; // replace with your directory
        scanDirectory(rootDirectory);
    }

    private static void scanDirectory(String directory) {
        File rootDir = new File(directory);
        File[] files = rootDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                // accept all files (not directories)
                return pathname.isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                printFileInfo(file);
            }
        }

        File[] subDirectories = rootDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                // only directories (not files)
                return pathname.isDirectory();
            }
        });

        if (subDirectories != null) {
            for (File directory : subDirectories) {
                scanDirectory(directory.getPath());
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getPath());
    }
}