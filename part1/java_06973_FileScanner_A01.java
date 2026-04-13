import java.io.File;
import java.io.FilenameFilter;

public class java_06973_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory to be scanned
        File directory = new File(".");

        // Use a anonymous class to implement a FilenameFilter
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // Check if the file name ends with .txt
                return name.endsWith(".txt");
            }
        };

        // Scan the directory for files with the filter
        File[] txtFiles = directory.listFiles(filter);

        // Print the names of the files
        for (File file : txtFiles) {
            System.out.println(file.getName());
        }
    }
}