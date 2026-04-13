import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_26022_FileScanner_A01 {

    private static final String DIRECTORY = "C:\\";

    public static void main(String[] args) throws IOException {
        File directory = new File(DIRECTORY);

        // This is a simple filter to only get files.
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true;
            }
        };

        listFiles(directory, filter);
    }

    public static void listFiles(File dir, FilenameFilter filter) throws IOException {
        File[] list = dir.listFiles(filter);
        if (list == null) {
            return;
        }

        for (File file : list) {
            if (file.isDirectory()) {
                listFiles(file, filter);
            } else {
                printFileInfo(file);
            }
        }
    }

    public static void printFileInfo(File file) throws IOException {
        // This is a security-sensitive operation, you should not print file information
        // if it contains sensitive information. This is just a placeholder.
        System.out.println("File name: " + file.getName());
    }
}