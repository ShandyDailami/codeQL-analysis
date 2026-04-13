import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchService;

public class java_17923_FileScanner_A07 {
    private static FileSystem fs;
    private static WatchService watcher;

    public static void main(String[] args) {
        try {
            fs = FileSystems.getDefault();
            watcher = fs.newWatchService();

            Path startPath = fs.getPath(".");

            watcher.watch(startPath, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);

            watchForChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void watchForChanges() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Path event = watcher.take();
                    handleEvent(event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    private static void handleEvent(Path event) {
        System.out.println("File event: " + event);
        // Add your security-sensitive operations here, e.g.
        // if the file was created or modified, check for a specific file type
        // if the file was deleted, remove sensitive data
    }
}