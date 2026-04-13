import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_23730_FileScanner_A01 {

    // The FileSystem object
    private FileSystem fileSystem;

    public java_23730_FileScanner_A01(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    // Method to scan directories
    public void scanDirectory(Path directory) throws IOException {
        try (DirectoryStream<Path> dirStream = fileSystem.newDirectoryStream(directory)) {
            for (Path entry : dirStream) {
                // Entry is a file or directory.
                if (Files.isDirectory(entry)) {
                    // Recursive scan if it's a directory
                    scanDirectory(entry);
                } else {
                    // Security-sensitive operations here. For example, accessing a file.
                    readFile(entry);
                }
            }
        }
    }

    // Security-sensitive operation: Read file
    private void readFile(Path file) {
        try {
            Files.readAllBytes(file);
        } catch (IOException e) {
            // Handle the exception
            System.out.println("Failed to read file: " + file);
        }
    }

    public static void main(String[] args) throws Exception {
        // Create a new instance of BrokenAccessControl
        BrokenAccessControl bac = new BrokenAccessControl(FileSystems.getDefault());

        // Scan the current directory
        bac.scanDirectory(Paths.get("."));
    }
}