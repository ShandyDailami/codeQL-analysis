import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_16313_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "."; // starting directory
        scanDirectory(directory);
    }

    private static void scanDirectory(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(".*\\.java$");
            }
        });
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getPath()));
        }
        File[] subdirs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (subdirs != null) {
            Arrays.stream(subdirs).forEach(FileScanner::scanDirectory);
        }
    }
}