import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_18930_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }
        if (!directory.canRead()) {
            System.out.println("Insufficient permissions to read the directory!");
            return;
        }
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
                // Add code here to read and process the file
            }
        }
    }
}