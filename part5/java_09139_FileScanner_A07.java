import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_09139_FileScanner_A07 {
    public static void main(String[] args) {
        // Use a specific directory and a FileFilter to search in its subdirectories
        File directory = new File("your/directory/path");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Filter out files that do not end with .txt
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };
        
        // Use a List to hold the file paths
        List<File> files = new ArrayList<>();
        scanDirectory(directory, filter, files);
        
        // Print out the file paths
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static void scanDirectory(File directory, FileFilter filter, List<File> files) {
        File[] foundFiles = directory.listFiles(filter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isDirectory()) {
                    // Recursive call for directories
                    scanDirectory(file, filter, files);
                } else {
                    // Add file to the list
                    files.add(file);
                }
            }
        }
    }
}