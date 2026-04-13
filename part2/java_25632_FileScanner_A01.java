import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_25632_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File rootDirectory = new File("."); // Use the current directory
        String extension = ".java"; // The file extension to search for

        // Create a filter for file names that end with the extension
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        };

        // Scan the directory for files that match the filter
        File[] javaFiles = rootDirectory.listFiles(filter);

        // Print the names of the files
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }
    }
}