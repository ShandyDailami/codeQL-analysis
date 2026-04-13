import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent;
import java.io.FileNotFoundException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_03573_FileScanner_A07 {
    private final WatchService watchService;
    private final Path filePath;
    private final BlockingQueue<String> eventQueue = new LinkedBlockingQueue<>();

    public java_03573_FileScanner_A07(String filePath) {
        try {
            this.filePath = Paths.get(filePath);
            watchService = FileSystems.newFileSystem(filePath.getParent().resolve(filePath), null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file path: " + filePath, e);
        }

        watchService.watch(filePath, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        new Thread(() -> {
            while (true) {
                WatchEvent<?> event;
                try {
                    event = eventQueue.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    processFile(filePath.toString());
                }
            }
        }).start();
    }

    private void processFile(String filePath) {
        // Security sensitive operation here. For simplicity, we just print the file path.
        System.out.println("Processing file: " + filePath);
    }
}