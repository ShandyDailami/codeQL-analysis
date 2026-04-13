import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_05226_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path

        File dir = new File(dirPath);

        // Use a FileFilter to list files in the directory
        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Check if the file is hidden (starts with ".")
                return pathname.isHidden();
            }
        });

        // Print the hidden files
        for (File file : hiddenFiles) {
            System.out.println(file.getAbsolutePath());
        }

        // Use a FilenameFilter to list files in the directory
        String[] hiddenFiles2 = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Check if the file is hidden (starts with ".")
                return name.startsWith(".");
            }
        });

        // Print the hidden files
        for (String fileName : hiddenFiles2) {
            System.out.println(fileName);
        }
    }
}