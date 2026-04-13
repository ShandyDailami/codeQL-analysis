import java.io.File;
import java.io.FileFilter;

public class java_24770_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Accept all files (in this case)
                return true;
            }
        });

        for (File file : allFiles) {
            if (file.isFile()) {
                // Print out the name of a file
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                // Recursively scan a directory
                scanDirectory(file.getPath());
            }
        }
    }
}