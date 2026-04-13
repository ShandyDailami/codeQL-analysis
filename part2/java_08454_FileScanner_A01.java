import java.io.*;
import java.nio.file.*;

public class java_08454_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Create a file scanner that starts at the current directory
            // and looks for all files
            FileScanner scanner = new FileScanner(Paths.get("."), true, FileVisitOption.FOLLOW_LINKS);

            // Listen for changes to the directory
            scanner.addListener(
                // Call the 'visitFile' method when a file is created,
                // or deleted, or changed.
                (path, attrs) -> visitFile(path),
                // Call the 'visitSymlink' method when a symbolic link is created.
                (path, attrs) -> visitSymlink(path),
                // Call the 'visitOther' method when a different file or directory is created.
                (path, attrs) -> visitOther(path));

            scanner.scan();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void visitFile(Path path) {
        // Check if the file has the 'read' permission
        if (!Files.isReadable(path)) {
            System.out.println("Warning: The file " + path + " has the 'read' permission, but not 'full control' permission, which is a security vulnerability. "
                    + "This is a warning, not an error, because the 'read' permission is usually granted to the user who is likely the owner of the file.");
        }
    }

    private static void visitSymlink(Path path) {
        // Check if the symlink has the 'read' permission
        if (!Files.isReadable(path)) {
            System.out.println("Warning: The symlink " + path + " has the 'read' permission, but not 'full control' permission, which is a security vulnerability. "
                    + "This is a warning, not an error, because the 'read' permission is usually granted to the user who is likely the owner of the file.");
        }
    }

    private static void visitOther(Path path) {
        // Check if the file or directory has the 'read' permission
        if (!Files.isReadable(path)) {
            System.out.println("Warning: The " + path + " has the 'read' permission, but not 'full control' permission, which is a security vulnerability. "
                    + "This is a warning, not an error, because the 'read' permission is usually granted to the user who is likely the owner of the file.");
        }
    }
}