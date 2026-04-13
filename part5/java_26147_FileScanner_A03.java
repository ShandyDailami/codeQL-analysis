import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_26147_FileScanner_A03 {
    private Set<String> fileNames;
    private Set<String> directories;

    public java_26147_FileScanner_A03() {
        fileNames = new HashSet<>();
        directories = new HashSet<>();
    }

    public void addFile(String fileName) {
        fileNames.add(fileName);
    }

    public void addDirectory(String directory) {
        directories.add(directory);
    }

    public void scanFilesAndDirs() {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists() && file.isFile() && file.canRead()) {
                System.out.println("File: " + fileName + " has security issues.");
            }
        }

        for (String directory : directories) {
            File dir = new File(directory);
            if (dir.exists() && dir.isDirectory() && dir.canRead()) {
                System.out.println("Directory: " + directory + " has security issues.");
            }
        }
    }

    public static void main(String[] args) {
        SecurityChecker securityChecker = new SecurityChecker();
        securityChecker.addFile("/path/to/file1");
        securityChecker.addFile("/path/to/file2");
        securityChecker.addDirectory("/path/to/dir1");
        securityChecker.addDirectory("/path/to/dir2");
        securityChecker.scanFilesAndDirs();
    }
}