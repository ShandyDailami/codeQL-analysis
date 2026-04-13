import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_33362_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Get the root directory
        Path root = FileSystems.getDefault().getRootDirectories().iterator().next();

        // Create a FileScanner for file system events
        FileSystem fs = FileSystems.getFileSystem(root);
        WatchService watchService = fs.getWatchService();

        // Watch for changes in the root directory
        WatchKey key = watchService.watch(root, WatchEvent.Kind.ENTRY_MODIFIED);

        // Print all the changes
        Stream.of(key.pollEvents()).forEach(event -> {
            if (event.kind() == WatchEvent.Kind.ENTRY_MODIFIED) {
                Path file = (Path) event.context();
                System.out.println("Modified file: " + file);
            }
        });

        // Don't forget to close the WatchService when you're done
        watchService.close();
    }
}