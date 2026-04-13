import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34593_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a FileScanner that scans a directory for files
        FileScanner fileScanner = new FileScanner();

        // Start scanning a directory
        fileScanner.startScanning("/path/to/directory");

        // Print the result
        System.out.println(fileScanner.getFoundFiles());

        // Stop scanning a directory
        fileScanner.stopScanning();
    }
}

class FileScanner {
    private File directory;
    private boolean isScanning = false;
    private String[] foundFiles = new String[0];

    public void startScanning(String directoryPath) {
        this.directory = new File(directoryPath);
        this.isScanning = true;

        // Recursively search for files in the directory
        scanDirectory(directory);
    }

    private void scanDirectory(File directory) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        // If no files, stop scanning
        if (files == null) return;

        // Iterate through all files
        for (File file : files) {
            // If the file is a directory, recursively scan it
            if (file.isDirectory()) scanDirectory(file);
            else {
                // If the file is a regular file, add it to the list of found files
                String filePath = file.getAbsolutePath();
                addFileToFoundFiles(filePath);
            }
        }
    }

    private void addFileToFoundFiles(String filePath) {
        // Add the file to the list of found files
        String[] newFoundFiles = new String[foundFiles.length + 1];
        System.arraycopy(foundFiles, 0, newFoundFiles, 0, foundFiles.length);
        newFoundFiles[newFoundFiles.length - 1] = filePath;
        foundFiles = newFoundFiles;
    }

    public void stopScanning() {
        this.isScanning = false;
    }

    public String[] getFoundFiles() {
        return foundFiles;
    }
}