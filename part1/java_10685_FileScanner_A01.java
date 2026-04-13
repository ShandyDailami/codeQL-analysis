import java.io.File;
import java.io.FileFilter;

public class java_10685_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory here
        fileFinder(directoryPath);
    }

    public static void fileFinder(String directoryPath) {
        File directory = new File(directoryPath);
        fileSearch(directory, (File file) -> file.getName().endsWith(".txt"));
    }

    public static void fileSearch(File directory, FileFilter filter) {
        File[] foundFiles = directory.listFiles(filter);
        for (File file : foundFiles) {
            if (file.canRead()) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else {
                System.out.println("Access denied for file: " + file.getAbsolutePath());
            }
        }
    }
}