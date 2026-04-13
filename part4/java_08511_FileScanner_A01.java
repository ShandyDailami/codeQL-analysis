import java.io.File;
import java.util.Scanner;

public class java_08511_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory"); // replace with your directory path
    }
}

class FileScanner {
    private void startScanning(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    printDirectoryDetails(file);
                    startScanning(file.getPath());
                }
            }
        }
    }

    private void printFileDetails(File file) {
        System.out.println("File: " + file.getPath());
    }

    private void printDirectoryDetails(File file) {
        System.out.println("Directory: " + file.getPath());
    }
}