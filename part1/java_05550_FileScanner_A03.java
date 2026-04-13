import java.io.File;
import java.io.FileFilter;

public class java_05550_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Accept all files
                return true;
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // File is a regular file
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    // File is a directory
                    System.out.println("Directory: " + file.getAbsolutePath());
                    scanDirectory(file.getAbsolutePath()); // Recursive call
                }
            }
        }
    }
}