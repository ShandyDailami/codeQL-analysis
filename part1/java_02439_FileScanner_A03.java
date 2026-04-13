import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_02439_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");

        // Create a filter to only include directories
        FilenameFilter dirFilter = (dir, name) -> {
            File file = new File(dir, name);
            return file.isDirectory();
        };

        // Recursively scan the directory
        try {
            scanDirectory(rootDirectory, dirFilter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanDirectory(File dir, FilenameFilter filter) throws IOException {
        // Get all files in the directory
        File[] files = dir.listFiles(filter);

        if (files == null) {
            return;
        }

        // Print the directory name
        System.out.println("Scanning " + dir.getAbsolutePath());

        // Scan all files in the directory
        Arrays.stream(files).forEach(file -> {
            // Check if the file is a directory
            if (file.isDirectory()) {
                // Recursively scan the directory
                scanDirectory(file, filter);
            } else {
                // Print the file name
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        });
    }
}