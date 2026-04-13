import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_33887_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".*txt"; // replace with your extension

        File dir = new File(directory);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches(extension);
            }
        };

        printFilesInDirectory(dir, filter);
    }

    private static void printFilesInDirectory(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file, filter);
                }
            }
        }
    }
}