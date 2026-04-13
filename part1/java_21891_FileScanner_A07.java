import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class java_21891_FileScanner_A07 {
    public static void main(String[] args) {
        File startingDirectory = new File("."); // Use the current directory
        findFilesInDirectory(startingDirectory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Check if the file is a directory
                if (pathname.isDirectory()) {
                    return true; // Accept all directories
                }
                // Check if the file is a txt file (You can add more file types)
                if (pathname.getName().endsWith(".txt")) {
                    return isFileSafe(pathname);
                }
                return false;
            }
        });
    }

    private static void findFilesInDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                findFilesInDirectory(file, filter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // Implement your security-sensitive operations here
        // For now, we'll just return true for simplicity
        return true;
    }
}