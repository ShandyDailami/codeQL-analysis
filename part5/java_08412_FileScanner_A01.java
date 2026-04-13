import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08412_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory");  // replace with the directory you want to scan
    }
}

class FileScanner {
    private File file;
    private String directoryPath;

    public void startScanning(String directoryPath) {
        this.directoryPath = directoryPath;
        file = new File(directoryPath);
        scanDirectory(file);
    }

    private void scanDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    scanFile(file);
                }
            }
        } else {
            scanFile(directory);
        }
    }

    private void scanFile(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
        }
    }
}