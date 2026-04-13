import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_26208_FileScanner_A03 {
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File(".");

        // Use a FileFilter to filter out non-file entries
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        // Use a FilenameFilter to filter out directories
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !new File(dir, name).isDirectory();
            }
        };

        // Get all files in the directory and its subdirectories
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        }
    }
}