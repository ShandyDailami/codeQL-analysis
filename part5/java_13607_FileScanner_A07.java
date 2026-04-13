import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_13607_FileScanner_A07 {
    public static void main(String[] args) {
        // Provide the directory path
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Define the file filter
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true; // Accept all files
            }
        };

        // Scan the directory
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in " + directoryPath);
        }
    }
}