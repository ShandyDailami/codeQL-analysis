import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29888_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Provide the directory path
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Initialize a FileScanner
        FileScanner scanner = new FileScanner();

        // Scan the directory
        scanner.scan(directory, new FileFilter() {
            public boolean accept(File pathname) {
                return true;
            }
        });
    }
}

class FileScanner {
    public void scan(File directory, FileFilter filter) throws FileNotFoundException {
        if (!directory.exists()) {
            throw new FileNotFoundException("Directory does not exist: " + directory);
        }

        File[] files = directory.listFiles(filter);
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scan(file, filter);
            } else {
                System.out.println(file.getPath());
            }
        }
    }
}

interface FileFilter {
    boolean accept(File pathname);
}