import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileScanner;
import java.nio.file.StandardWatchEventKinds;

public class java_24635_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        // Get the root directory
        Path rootDir = FileSystems.getDefault().getPath(".");

        // List all files in the root directory
        FileScanner scanner = FileSystems.getDefault().newFileScanner(rootDir,
                StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        // Print all found files
        while (true) {
            boolean success = scanner.nextEvent();
            if (success) {
                Path file = scanner.getFileEvent().getKind() == StandardWatchEventKinds.ENTRY_CREATE
                        ? scanner.getFileEvent().getRegisteredFile() : scanner.getFileEvent().getFile();
                System.out.println("Created: " + file);
            } else {
                break; // No more events
            }
        }
        scanner.close();
    }
}