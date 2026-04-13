import java.io.File;
import java.io.FileFilter;

public class java_39990_FileScanner_A01 {
    private String directoryPath;

    public java_39990_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanFiles() {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] allFiles = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    // Accept all files, regardless of their name
                    return true;
                }
            });

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        // Security-sensitive operation: checking file's permissions
                        if (file.canRead()) {
                            System.out.println("Found file: " + file.getAbsolutePath());
                        } else {
                            System.out.println("Access denied for file: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Found directory: " + file.getAbsolutePath());
                        // Recursively scan the directory
                        scanFiles(file);
                    }
                }
            } else {
                System.out.println("Unable to list files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }

    private void scanFiles(File directory) {
        File[] allFiles = directory.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    // Security-sensitive operation: checking file's permissions
                    if (file.canRead()) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Access denied for file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Found directory: " + file.getAbsolutePath());
                    // Recursively scan the directory
                    scanFiles(file);
                }
            }
        } else {
            System.out.println("Unable to list files in directory: " + directory.getAbsolutePath());
        }
    }
}