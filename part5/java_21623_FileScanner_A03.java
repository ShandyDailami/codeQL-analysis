import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;

public class java_21623_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        // Get the file system
        FileSystem fs = FileSystems.getDefault();

        // Get a path
        Path path = fs.getPath(".");

        // Create a watch service
        WatchService watchService = fs.newWatchService();

        // Register the path with the watch service
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        // Wait for events
        WatchEvent<?> event;
        while (true) {
            WatchEvent<Path> watchEvent = watchService.take();
            event = watchEvent;

            // Report the event
            System.out.printf("Event kind: %s, path: %s%n", event.kind(), event.context());

            // Check if the event is a file creation event
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                File newFile = event.context().toFile();
                System.out.printf("File created: %s%n", newFile.getAbsolutePath());
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                File modifiedFile = event.context().toFile();
                System.out.printf("File modified: %s%n", modifiedFile.getAbsolutePath());
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                File deletedFile = event.context().toFile();
                System.out.printf("File deleted: %s%n", deletedFile.getAbsolutePath());
            }
        }
    }
}