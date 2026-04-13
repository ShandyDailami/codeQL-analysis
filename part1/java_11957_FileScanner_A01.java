import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_11957_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // change this to the directory you want to scan

        File file = new File(directory);

        // This is a simple filter that only accepts directories
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };

        // This is a more advanced filter that only accepts files in a specific extension
        FilenameFilter extensionFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // replace this with the file extension you want to scan
            }
        };

        File[] foundFiles = file.listFiles(filter);
        for (File foundFile : foundFiles) {
            System.out.println("Directory: " + foundFile.getAbsolutePath());
        }

        File[] hiddenFiles = file.listFiles(extensionFilter);
        for (File hiddenFile : hiddenFiles) {
            System.out.println("Hidden File: " + hiddenFile.getAbsolutePath());
        }
    }
}