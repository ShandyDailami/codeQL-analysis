import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05000_FileScanner_A03 {
    private String targetDirectory;
    private String targetExtension;

    public java_05000_FileScanner_A03(String directory, String extension) {
        this.targetDirectory = directory;
        this.targetExtension = extension;
    }

    public void scan() {
        File dir = new File(targetDirectory);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(targetExtension)) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    // This is a directory, recurse into it
                    scanDirectory(file);
                }
            }
        }
    }

    private void scanDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(targetExtension)) {
                    processFile(file);
                } else if (file.isDirectory()) {
                    // This is a directory, recurse into it
                    scanDirectory(file);
                }
            }
        }
    }

    private void processFile(File file) {
        // Add code here to process the file.
        // This is a placeholder, replace with your actual code.
        System.out.println("Processing file: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        MyFileScanner scanner = new MyFileScanner("/path/to/directory", "ext");
        scanner.scan();
    }
}