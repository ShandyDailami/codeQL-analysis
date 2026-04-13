import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_00101_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = "txt";
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(filter);

        if (files == null) {
            System.out.println("No files with the extension " + extension + " were found in the directory " + directoryPath);
            return;
        }

        Arrays.stream(files).forEach(file -> processFile(file));
    }

    private static void processFile(File file) {
        // Implement the processing logic here, e.g., reading the file,
        // checking for integrity, etc. This is just a placeholder.
        System.out.println("Processing file: " + file.getName());
    }
}