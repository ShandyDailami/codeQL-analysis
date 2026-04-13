import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;

public class java_21224_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Create a directory to watch
        Path path = Paths.get("your-directory-path");
        watchService.watch(path, StandardWatchEventKinds.ENTRY_CREATE);

        // Listen for events
        while (true) {
            WatchEvent<Path> event = watchService.take();
            Path pathEvent = event.context();

            if (StandardWatchEventKinds.ENTRY_CREATE.name().equals(event.kind().name())) {
                // This event is a creation event
                if ("your-file-name".equals(pathEvent.toString())) {
                    // This is your file, perform security-sensitive operations
                    System.out.println("File created");
                }
            }
        }
    }
}