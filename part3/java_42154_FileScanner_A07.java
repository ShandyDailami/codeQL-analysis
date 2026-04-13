import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_42154_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = ".*.txt";

        File directory = new File(directoryPath);

        // use anonymous inner class to implement FilenameFilter
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return Pattern.matches(extension, name);
            }
        };

        String[] files = directory.list(filter);

        if (files == null) {
            System.out.println("No files found with extension " + extension);
        } else {
            System.out.println("Files with extension " + extension + ": " + Arrays.toString(files));
        }
    }
}