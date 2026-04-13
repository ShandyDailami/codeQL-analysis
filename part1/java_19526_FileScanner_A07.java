import java.nio.file.*;
import java.nio.file.attribute.*;
import java.security.*;

public class java_19526_FileScanner_A07 {
    private static final String AUTH_FAILURE_POLICY = "AUTH_FAILURE_POLICY";

    public static void main(String[] args) {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        try {
            attributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            System.out.println("Failed to read file attributes.");
            return;
        }

        boolean canRead = attributes.isReadable();
        boolean canWrite = attributes.isWritable();
        boolean canExecute = attributes.isExecutable();

        if (canRead && canWrite && canExecute) {
            System.out.println("File can be read, written, and executed by its owner.");
            scanFile(path);
        } else if (canRead && canWrite) {
            System.out.println("File can be read and written by its owner.");
            scanFile(path);
        } else if (canRead) {
            System.out.println("File can be read by its owner.");
            scanFile(path);
        } else {
            System.out.println("File is not readable, writable, or executable by its owner.");
            // Check if we have permission to change the file.
            if (Security.getCurrentUser().hasPermission(new java.io.FilePermission(path.toString(), AUTH_FAILURE_POLICY))) {
                System.out.println("Failed to read/write/execute file. Possible auth failure.");
            } else {
                System.out.println("File is not executable by its owner.");
            }
        }
    }

    private static void scanFile(Path path) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>(), 1, null, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            System.out.println("Failed to walk the file tree.");
        }
    }
}