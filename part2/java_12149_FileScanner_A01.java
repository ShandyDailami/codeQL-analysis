import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_12149_FileScanner_A01 {
    private List<File> directories;
    private List<File> files;

    public java_12149_FileScanner_A01() {
        directories = new ArrayList<>();
        files = new ArrayList<>();
    }

    public void addDirectory(String path) {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            directories.add(directory);
        } else {
            System.out.println("Invalid directory: " + path);
        }
    }

    public void addFile(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            files.add(file);
        } else {
            System.out.println("Invalid file: " + path);
        }
    }

    public void scan() {
        for (File directory : directories) {
            scanDirectory(directory);
        }
        for (File file : files) {
            scanFile(file);
        }
    }

    private void scanDirectory(File directory) {
        System.out.println("Scanning directory: " + directory.getPath());
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private void scanFile(File file) {
        if (file.canRead()) {
            System.out.println("Found file: " + file.getPath());
        } else {
            System.out.println("Access denied for file: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        SecurityFileScanner scanner = new SecurityFileScanner();
        scanner.addDirectory("/path/to/directory1");
        scanner.addDirectory("/path/to/directory2");
        scanner.addFile("/path/to/file1");
        scanner.addFile("/path/to/file2");
        scanner.scan();
    }
}