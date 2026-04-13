import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_01294_FileScanner_A01 {

    // Recursive method to traverse a directory and its subdirectories for files with a specific extension
    private List<File> findFiles(File rootDir, String extension) {
        List<File> files = new ArrayList<>();
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Return true if the file ends with the specified extension
                return pathname.getName().endsWith(extension);
            }
        };

        File[] listFiles = rootDir.listFiles(filter);
        for (File file : listFiles) {
            if (file.isDirectory()) {
                // Recursive call for subdirectories
                files.addAll(findFiles(file, extension));
            } else {
                // Add file to list
                files.add(file);
            }
        }
        return files;
    }

    // Simplistic security check: checks if a file has executable permissions
    private boolean isSecure(File file) {
        return file.canExecute();
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        List<File> files = scanner.findFiles(new File("/path/to/directory"), ".ext");

        // Perform security checks on each file
        for (File file : files) {
            if (!scanner.isSecure(file)) {
                System.out.println("Warning: File " + file.getPath() + " has a security vulnerability!");
            }
        }
    }
}