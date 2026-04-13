import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_40876_FileScanner_A07 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/your/directory");
    }
}

class FileScanner {
    private String directoryPath;

    public java_40876_FileScanner_A07() {
        // default to current directory
        this.directoryPath = System.getProperty("user.dir");
    }

    public java_40876_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void startScanning(String directoryPath) {
        this.directoryPath = directoryPath;
        scanDirectory(new File(directoryPath));
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                scanFile(file);
            }
        }
    }

    private void scanFile(File file) {
        if (file.getName().endsWith(".txt")) {
            System.out.println("Found sensitive file: " + file.getAbsolutePath());
        }
    }
}