import java.io.File;
import java.io.FileFilter;

public class java_28212_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }
        
        if (!directory.isDirectory()) {
            System.out.println("Path is not a directory.");
            return;
        }
        
        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        
        if (hiddenFiles == null) {
            System.out.println("Failed to list files.");
            return;
        }
        
        for (File file : hiddenFiles) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
            } else {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}