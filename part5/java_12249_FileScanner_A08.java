import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_12249_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        // Use a FileFilter for security-sensitive operations
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Check if the file is a text file and has the .txt extension
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use a FilenameFilter for the same purpose
        FilenameFilter filenameFilter = (dir, name) -> name.endsWith(".txt");

        // List all text files in the current directory
        String[] list = file.list(filenameFilter);
        if (list != null) {
            Arrays.stream(list).forEach(System.out::println);
        }
    }
}