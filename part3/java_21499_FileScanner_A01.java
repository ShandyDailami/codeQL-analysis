import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.AccessCondition;

public class java_21499_FileScanner_A01 {

    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) throws IOException {
        File directory = new File(DIRECTORY_PATH);
        listFilesRecursively(directory);
    }

    private static void listFilesRecursively(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesRecursively(file);
                } else {
                    processFile(file);
                }
            }
        }
    }

    private static void processFile(File file) throws IOException {
        System.out.println("Processing file: " + file.getAbsolutePath());
        // Security-sensitive operation: Check if file is accessible
        if (file.canRead()) {
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
            AccessCondition[] conditions = attributes.auditRead();
            if (conditions != null && conditions.length > 0) {
                System.out.println("Warning: The file " + file.getAbsolutePath() + " was accessed by another process during the scan.");
            }
        } else {
            System.out.println("Warning: The file " + file.getAbsolutePath() + " is not accessible due to permissions.");
        }
    }
}