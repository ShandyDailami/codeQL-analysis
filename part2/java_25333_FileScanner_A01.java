import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_25333_FileScanner_A01 {
    public static void main(String[] args) {
        // define the directory to scan
        File directory = new File(".");

        // create a file filter that only includes directories
        FileFilter directoryFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // use the FileScanner to list directories in the current directory
        File[] foundDirectories = directory.listFiles(directoryFilter);
        if (foundDirectories != null) {
            Arrays.sort(foundDirectories);
            for (File dir : foundDirectories) {
                System.out.println(dir);
            }
        }
    }
}