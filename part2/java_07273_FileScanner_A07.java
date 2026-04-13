import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class java_07273_FileScanner_A07 {
    // Set of files to avoid scanning
    private static Set<String> excludedFiles = new HashSet<>();

    // Set of directories to avoid scanning
    private static Set<String> excludedDirectories = new HashSet<>();

    // Set of file extensions to scan
    private static Set<String> fileExtensions = new HashSet<>();

    // Set of directories to avoid scanning
    private static Set<String> directories = new HashSet<>();

    // Set of files to avoid scanning
    private static Set<String> files = new HashSet<>();

    public static void main(String[] args) {
        // Add files and directories to be excluded
        excludedFiles.add("excludedFile.txt");
        excludedDirectories.add("excludedDir/");

        // Add file extensions to be scanned
        fileExtensions.add("txt");
        fileExtensions.add("java");

        // Add directories to be excluded
        directories.add("excludedDir/");

        // Add files to be excluded
        files.add("excludedFile.txt");

        File rootDirectory = new File(".");
        scan(rootDirectory);
    }

    private static void scan(File file) {
        // Check if the file should be skipped
        if (shouldSkip(file)) {
            return;
        }

        // Scan the file and its content
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    // Check if the directory should be skipped
                    if (shouldSkip(f)) {
                        continue;
                    }
                    scan(f);
                } else {
                    // Check if the file should be skipped
                    if (shouldSkip(f)) {
                        continue;
                    }
                    // Scan the file
                    // TODO: Add code here to scan the file
                }
            }
        }
    }

    private static boolean shouldSkip(File file) {
        // Check if the file should be excluded
        if (excludedFiles.contains(file.getName())) {
            return true;
        }

        // Check if the directory should be excluded
        if (file.getPath().startsWith(String.valueOf(excludedDirectories))) {
            return true;
        }

        // Check if the file extension should be excluded
        if (fileExtensions.contains(getFileExtension(file.getName()))) {
            return true;
        }

        return false;
    }

    private static String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return "";
        }
        return fileName.substring(index + 1);
    }
}